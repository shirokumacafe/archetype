package com.shirokumacafe.archetype.web;

import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Lim
 * Date: 13-6-9
 * Time: 下午5:09
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class MainController {

    @Autowired
    private MenuService menuService;
    @RequestMapping(value = "/main")
    public String toMain(Model model){
        model.addAttribute("menus", Responses.writeJson( menuService.getAllMenu() ) );
        return "main";
    }

}
