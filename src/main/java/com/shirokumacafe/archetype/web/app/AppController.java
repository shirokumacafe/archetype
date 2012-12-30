package com.shirokumacafe.archetype.web.app;

import com.google.common.collect.Maps;
import com.shirokumacafe.archetype.entity.Task;
import com.shirokumacafe.archetype.entity.User;
import com.shirokumacafe.archetype.service.account.ShiroDbRealm;
import com.shirokumacafe.archetype.service.task.TaskService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springside.modules.web.Servlets;

import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * 应用入口的Controller
 * @author lim
 */
@Controller
@RequestMapping(value = "/app")
public class AppController {

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



    /**
     * 取出Shiro中的当前用户Id.
     */
    private Long getCurrentUserId() {
        ShiroDbRealm.ShiroUser user = (ShiroDbRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user.id;
    }
}

