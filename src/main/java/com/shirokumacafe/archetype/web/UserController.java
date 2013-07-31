
package com.shirokumacafe.archetype.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户管理
 * @author Lim
 */
@Controller
@RequestMapping(value = "/user")
class UserController {

    @RequestMapping
    public String to(){
        return "user";
    }
}



