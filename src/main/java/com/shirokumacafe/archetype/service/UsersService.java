package com.shirokumacafe.archetype.service;

import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.entity.Users;
import com.shirokumacafe.archetype.entity.UsersExample;
import com.shirokumacafe.archetype.repository.UsersMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户管理Service
 *
 * @author Lim
 */
@Component
@Transactional
public class UsersService {
    @Autowired
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

    public void add(Users user) {
        usersMapper.insert(user);
    }

    public void update(Users user) {
        usersMapper.updateByPrimaryKeySelective(user);
    }

    public void delete(Users user) {
        usersMapper.deleteByPrimaryKey(user.getUserId());
    }

}
