package com.shirokumacafe.archetype.service;

import com.shirokumacafe.archetype.entity.Menu;
import com.shirokumacafe.archetype.repository.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Lim
 * Date: 13-6-9
 * Time: 下午5:13
 * To change this template use File | Settings | File Templates.
 */
@Component
@Transactional
public class MenuService {
    @Autowired
    private MenuMapper menuMapper;

    /**
     * 获取所有目录以及按钮
     */
    public List<Menu> findAllMenu(){
        List<Menu> menus = menuMapper.selectByExample(null);
        return menus;

    }

    public void add(Menu menu){
        menuMapper.insert(menu);
    }

    public void update(Menu menu){
        menuMapper.updateByPrimaryKeySelective(menu);
    }

    public void delete(Menu menu){
        menuMapper.deleteByPrimaryKey(menu.getMenuId());
    }
}
