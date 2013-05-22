package com.shirokumacafe.archetype.web.app;

import com.shirokumacafe.archetype.common.base.MyController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 应用入口的Controller
 * @author lim
 */
@Controller
@RequestMapping(value = "/app")
public class AppController extends MyController{

    @RequestMapping(value = "")
    public String list() {

        return "app/app";
    }
    @RequestMapping(value = "tab")
    public String tab() {
        return "app/tab";
    }
    @RequestMapping(value = "tab2")
    public String tab2() {

        return "app/tab2";
    }
    @RequestMapping(value = "add")
    @ResponseBody
    public String add() {

        return "success";
    }



}

