
package com.shirokumacafe.archetype.web;

import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.Users;
import com.shirokumacafe.archetype.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 用户管理
 * @author Lim
 */
@Controller
@RequestMapping(value = "/user")
class UserController {
    @Autowired
    private UsersService usersService;


    @RequestMapping
    public String to(){
        return "user";
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public String list(Users user,Page page){
        Page<Users> users = usersService.findUserForPage(user,page);
        return Responses.writeJson(users);
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public Map add(Users user){
        usersService.add(user);
     return Responses.writeSuccess();
    }
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    @ResponseBody
    public Map update(Users user){
        usersService.update(user);
        return Responses.writeSuccess();
    }
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public Map delete(Users user){
        usersService.delete(user);
        return Responses.writeSuccess();
    }
}



