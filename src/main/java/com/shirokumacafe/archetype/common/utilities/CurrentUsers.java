package com.shirokumacafe.archetype.common.utilities;

import com.shirokumacafe.archetype.service.ShiroDbRealm;
import org.apache.shiro.SecurityUtils;

/**
 * 从Shiro中获取当前用户相关信息
 * @author lim
 */
public class CurrentUsers {

    public static String getCurrentUserName() {
        ShiroDbRealm.ShiroUser user = (ShiroDbRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user.loginName;
    }

    public static Integer getCurrentUserId() {
        ShiroDbRealm.ShiroUser user = (ShiroDbRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user.id;
    }
}
