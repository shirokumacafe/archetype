package com.shirokumacafe.archetype.common.base;


import com.shirokumacafe.archetype.common.utilities.JsonMapper;

import org.springframework.stereotype.Controller;

/**
 * Controller基类
 *
 * SpringMVC默认是单实例的，在单实例模式时禁止任何带有状态的实例变量或静态变量，同时需要注意方法里的写法是否有线程安全问题.
 * 在基类与子类上标注@Scope("prototype")，使SpringMVC变为多实例.
 *
 * @author lim
 */
@Controller
public class MyController {

//    protected final static ResponseUtil responseUtil = new ResponseUtil();

    protected final static JsonMapper objectMapper = JsonMapper.nonDefaultMapper();



}
