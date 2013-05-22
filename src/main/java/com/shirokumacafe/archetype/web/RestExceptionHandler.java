package com.shirokumacafe.archetype.web;

import com.shirokumacafe.archetype.common.utilities.ResponseUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局Exception Handler，提供友好的错误输出
 */
@ControllerAdvice
public class RestExceptionHandler {

    /**
     * Runtime异常处理
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public final Object handleRuntimeException(RuntimeException e) {
        e.printStackTrace();
        return ResponseUtil.writeFailAndMsg(null == e.getMessage() ?
                "嘿！程序运行出错了，请稍后再试！" : e.getMessage());
    }

    /**
     * Throwable异常处理(顶层)
     */
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public final Object handleException(Throwable e) {
        e.printStackTrace();
        return ResponseUtil.writeFailAndMsg("嘿！程序运行出错了，请联系维护人员！");
    }

}