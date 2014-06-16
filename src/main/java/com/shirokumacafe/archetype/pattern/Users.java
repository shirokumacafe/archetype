package com.shirokumacafe.archetype.pattern;

import com.shirokumacafe.archetype.service.ShiroDbRealm;
import org.apache.shiro.SecurityUtils;

/**
 * 从Shiro中获取当前用户相关信息
 *
 * @author lim
 */
public class Users {

    public static ShiroDbRealm.ShiroUser getCurrentUser() {
        ShiroDbRealm.ShiroUser user = (ShiroDbRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user;
    }

    public static Integer getCurrentUserId() {
        ShiroDbRealm.ShiroUser user = (ShiroDbRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user.id;
    }

    public static String getCurrentHost() {
        return SecurityUtils.getSubject().getSession().getHost();
    }


}
