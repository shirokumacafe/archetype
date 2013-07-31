package com.shirokumacafe.archetype.web;

import com.shirokumacafe.archetype.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 菜单管理
 * @author Lim
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping
    public String to(){
        return "menu";
    }

}
