package com.shirokumacafe.archetype.common.utilities;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
* 应答工具类
*
* @author lim
*/
public class ResponseUtil {
    private final static String SUCCESS = "success";
    private final static String MSG = "msg";


     /**
     * 创建后台验证错误，返回对象
     */
    public static Map writeFailAndMsg(String errors){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put(SUCCESS,false);
        map.put(MSG,errors);
        return Collections.unmodifiableMap(map);
    }
    /**
     * 创建后台验证错误
     */
    public static Map writeFail(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put(SUCCESS,false);
        map.put(MSG,"系统出错！");
        return map;
    }
    /**
     * 后台操作成功，返回对象
     */
    public static Map writeSuccessAndMsg(Map<String,Object> msg){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put(SUCCESS,true);
        map.put(MSG,msg);
        return Collections.unmodifiableMap(map);
    }
    /**
     * 后台操作成功
     */
    public static Map writeSuccess(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put(SUCCESS,true);
        return map;
    }

    /**
     * 上传文件成功
     */
    public static void writeUploadSuccess(HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            response.getWriter().write("{success:true}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 上传文件失败
     */
    public static void writeUploadFail(HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            response.getWriter().write("{success:false}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
