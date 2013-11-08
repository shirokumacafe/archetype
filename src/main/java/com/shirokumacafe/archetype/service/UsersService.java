package com.shirokumacafe.archetype.service;

import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.utilities.CurrentUsers;
import com.shirokumacafe.archetype.common.utilities.Digests;
import com.shirokumacafe.archetype.common.utilities.Encodes;
import com.shirokumacafe.archetype.entity.Users;
import com.shirokumacafe.archetype.entity.UsersExample;
import com.shirokumacafe.archetype.repository.UsersMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 用户管理Service
 *
 * @author Lim
 */
@Component
@Transactional
public class UsersService {

    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    private static final int SALT_SIZE = 8;

    private static Logger logger = LoggerFactory.getLogger(UsersService.class);

    private UsersMapper usersMapper;

    public Page<Users> findUserForPage(Users user,Page page) {
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotBlank(user.getUserCode())) {
            criteria.andUserCodeLike("%" + user.getUserCode() + "%");
        }
        if (StringUtils.isNotBlank(user.getUserName())) {
            criteria.andUserNameLike("%" + user.getUserName() + "%");
        }
        if (null != user.getSex()) {
            criteria.andSexEqualTo(user.getSex());
        }
        if (null != user.getState()) {
            criteria.andStateEqualTo(user.getState());
        }

        List<Users> rows = usersMapper.selectByExampleWithRowbounds(example,page.createRowBounds());
        Integer results = usersMapper.countByExample(example);
        page.setRows(rows);
        page.setResults(results);

        return page;
    }

    public Users findUserByLoginName(String loginName){
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andLoginNameEqualTo(loginName);
        Users user = usersMapper.selectByExample(example).get(0);
        return user;
    }

    public void add(Users user) {
//        user.setUserId();
        user.setCreateTime(new Date());
        usersMapper.insert(user);
    }

    public void update(Users user) {
        user.setUpdateTime(new Date());
        usersMapper.updateByPrimaryKeySelective(user);
    }

    public void delete(List<Integer> ids) {

        if (isSupervisor(ids)) {
            logger.warn("操作员{}尝试删除超级管理员用户", CurrentUsers.getCurrentUserName());
            throw new ServiceException("不能删除超级管理员用户");
        }

        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdIn(ids);
        usersMapper.deleteByExample(example);
    }

    /**
     * 判断是否超级管理员.
     */
    private boolean isSupervisor(List<Integer> ids) {
        return ids.contains(1);
    }

    /**
     * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
     */
    private void entryptPassword(Users user) {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        user.setSalt(Encodes.encodeHex(salt));

        byte[] hashPassword = Digests.sha1(user.getPassword().getBytes(), salt, HASH_INTERATIONS);
        user.setPassword(Encodes.encodeHex(hashPassword));
    }

    @Autowired
    public void setUsersMapper(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    public static void main(String[] args) {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        System.out.println(Encodes.encodeHex(salt));

        byte[] hashPassword = Digests.sha1("123456".getBytes(), salt, HASH_INTERATIONS);
        System.out.println(Encodes.encodeHex(hashPassword));
    }
}
