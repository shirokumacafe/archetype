package com.shirokumacafe.archetype.service;

import com.shirokumacafe.archetype.common.exception.ServiceException;
import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.security.utils.Digests;
import com.shirokumacafe.archetype.common.utilities.CurrentUsers;
import com.shirokumacafe.archetype.common.utilities.Encodes;
import com.shirokumacafe.archetype.entity.User;
import com.shirokumacafe.archetype.entity.UserExample;
import com.shirokumacafe.archetype.repository.UserMapper;
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
public class UserService {

    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    private static final int SALT_SIZE = 8;

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserMapper userMapper;

    public Page<User> findUserForPage(User user,Page page) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();

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

        List<User> rows = userMapper.selectByExampleWithRowbounds(example,page.createRowBounds());
        Integer results = userMapper.countByExample(example);
        page.setRows(rows);
        page.setResults(results);

        return page;
    }

    public User findUserByLoginName(String loginName){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andLoginNameEqualTo(loginName);
        User user = null;
        try {
            user = userMapper.selectByExample(example).get(0);
        } catch (Exception e) {
            //忽略
        }
        return user;
    }

    public void add(User user) {

        user.setCreateTime(new Date());
        userMapper.insert(user);
    }

    public void update(User user) {

        user.setUpdateTime(new Date());
        userMapper.updateByPrimaryKeySelective(user);
    }

    public void delete(List<Integer> ids) {

        if (isSupervisor(ids)) {
            logger.warn("操作员{}尝试删除超级管理员用户", CurrentUsers.getCurrentUserName());
            throw new ServiceException("不能删除超级管理员用户");
        }

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdIn(ids);
        userMapper.deleteByExample(example);
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
    private void entryptPassword(User user) {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        user.setSalt(Encodes.encodeHex(salt));

        byte[] hashPassword = Digests.sha1(user.getPassword().getBytes(), salt, HASH_INTERATIONS);
        user.setPassword(Encodes.encodeHex(hashPassword));
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public static void main(String[] args) {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        System.out.println(Encodes.encodeHex(salt));

        byte[] hashPassword = Digests.sha1("123456".getBytes(), salt, HASH_INTERATIONS);
        System.out.println(Encodes.encodeHex(hashPassword));
    }
}
