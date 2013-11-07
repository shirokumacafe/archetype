package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.Menu;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: SHIROKUMA
 * Date: 13-10-23
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
public interface MenuXMLMapper {

    List<Menu> findMenuByCodeForList(String code);
}
