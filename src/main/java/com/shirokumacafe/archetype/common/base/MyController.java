package com.shirokumacafe.archetype.common.base;


import com.shirokumacafe.archetype.common.utilities.JsonMapper;
import com.shirokumacafe.archetype.common.utilities.Responses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Controller基类
 *
 * @author lim
 */
@Controller
public class MyController {

    @Autowired
    protected JsonMapper objectMapper;

    protected Responses responseUtil;



}
