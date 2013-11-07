package com.shirokumacafe.archetype.web;

import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主界面
 * @author Lim
 */
@Controller
public class MainController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/main")
    public String to(Model model){
        model.addAttribute("menus", Responses.writeJson( menuService.buildAllMenu() ) );
        return "main";
    }

}
