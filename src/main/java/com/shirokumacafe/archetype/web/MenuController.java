package com.shirokumacafe.archetype.web;

import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.Menu;
import com.shirokumacafe.archetype.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 菜单管理
 * @author Lim
 */
@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping
    public String to(Model model){
        model.addAttribute("menus", Responses.writeJson(menuService.findRootMenu()) );
        return "menu";
    }

    @RequestMapping("list")
     @ResponseBody
     public String list(){
        return Responses.writeJson(menuService.findAllMenu());
    }

    @RequestMapping("findMenu")
    @ResponseBody
    public String findMenu(String code){
        return Responses.writeJson(menuService.findMenu(code));
    }
}
