package com.shirokumacafe.archetype.service;

import com.shirokumacafe.archetype.entity.Menu;
import com.shirokumacafe.archetype.entity.MenuExample;
import com.shirokumacafe.archetype.repository.MenuMapper;
import com.shirokumacafe.archetype.repository.MenuXMLMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单管理Service
 * @author lim
 */
@Component
@Transactional
public class MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MenuXMLMapper menuXMLMapper;
    /**
     * 获取所有目录以及按钮
     */
    public List<Menu> findAllMenu(){
        List<Menu> menus = menuMapper.selectByExample(null);
        return menus;
    }



    public List buildAllMenu(){
        MenuExample rootExample = new MenuExample();
        MenuExample.Criteria rootCriteria = rootExample.createCriteria();
        rootCriteria.andMenuParentEqualTo("ROOT");
        rootExample.setOrderByClause("sort");
        List<Menu> rootMenus = menuMapper.selectByExample(rootExample);
//        List<Map<String,Object>> secondMenus = new ArrayList<Map<String, Object>>();
        List<Map<String,Object>> thirdMenus = new ArrayList<Map<String, Object>>();
        for(Menu root :rootMenus){
            Map<String,Object> rootMap = new HashMap<String, Object>();
            rootMap.put("id",root.getMenuCode());

            MenuExample secondExample = new MenuExample();
            MenuExample.Criteria secondCriteria = secondExample.createCriteria();
            secondCriteria.andMenuParentEqualTo(root.getMenuCode());
            secondExample.setOrderByClause("sort");
            List<Menu> secondMenus = menuMapper.selectByExample(secondExample);

//            List<Map<String,Object>> secondMenus = new ArrayList<Map<String, Object>>();
            for(Menu second :secondMenus){
                Map<String,Object> secondMap = new HashMap<String, Object>();

            }

//            secondMap.put("menu","");

        }
//        List build = new ArrayList();
//        for(Menu menu: menus){
//            Map<String,Object> map = new HashMap<String, Object>();
//            List<Menu> menuList = menuXMLMapper.findMenuByCodeForList(menu.getMenuCode());
//            List<Map<String,Object>> items = new ArrayList<Map<String, Object>>();
//            for(Menu item: menuList){
//                Map<String,Object> itemMap = new HashMap<String, Object>();
//                itemMap.put("id",item.getMenuCode());
//                itemMap.put("text",item.getMenuName());
//                itemMap.put("href",item.getLink());
//
//                items.add(itemMap);
//            }
//            map.put("id",menu.getMenuCode());
//            map.put("menu",items);
//            build.add(map);
//        }

        return null;
    }

    /**
     * 获取根节点
     */
    public List<Menu> findRootMenu(){
        MenuExample example = new MenuExample();
        MenuExample.Criteria criteria = example.createCriteria();
        criteria.andMenuParentEqualTo("ROOT");
        List<Menu> menus = menuMapper.selectByExample(example);
        return menus;

    }

    /**
     * 根据父亲代码找到子节点
     */
    public List<Menu> findMenu(String code){
        MenuExample example = new MenuExample();
        MenuExample.Criteria criteria = example.createCriteria();
        criteria.andMenuCodeEqualTo(code);
        List<Menu> menus = menuMapper.selectByExample(example);
        return menus;

    }

    public void add(Menu menu){
        menuMapper.insert(menu);
    }

    public void update(Menu menu){
        menuMapper.updateByPrimaryKeySelective(menu);
    }

    public void delete(Menu menu){
        menuMapper.deleteByPrimaryKey(menu.getMenuCode());
    }

}
