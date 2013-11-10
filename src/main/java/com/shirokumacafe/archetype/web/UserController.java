
package com.shirokumacafe.archetype.web;

import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.User;
import com.shirokumacafe.archetype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
    private UserService userService;


    @RequestMapping
    public String to(){
        return "user";
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public String list(User user,Page page){
        Page<User> users = userService.findUserForPage(user,page);
        return Responses.writeJson(users);
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public Map add(User user){
        userService.add(user);
     return Responses.writeSuccess();
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public Map update(User user){
        userService.update(user);
        return Responses.writeSuccess();
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public Map delete(@RequestParam(value = "ids") List<Integer> ids){
        userService.delete(ids);
        return Responses.writeSuccess();
    }
}



