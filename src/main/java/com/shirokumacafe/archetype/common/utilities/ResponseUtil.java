//package com.shirokumacafe.archetype.common.utilities;
//
//import com.google.common.collect.ImmutableMap;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Map;
//
///**
// * 针对EXT封装的统一响应
// *
// * @author lim
// */
//
//public class ResponseUtil {
//    private final static String SUCCESS = "success";
//    private final static String MSG = "msg";
//    private final static String ERROR = "error";
//    private final static String ERRORS = "errors";
//
//     /**
//     * 创建后台验证错误，返回对象
//     */
//    public Map writeFailAndMsg(String errors){
//        return ImmutableMap.of(SUCCESS,false,MSG,errors);
//    }
//    /**
//     * 创建后台验证错误
//     */
//    public Map writeFail(){
//        return ImmutableMap.of(SUCCESS,false,MSG,"程序出错了，请联系管理员以便解决问题！");
//    }
//    /**
//     * 后台操作成功，返回对象
//     */
//    public Map writeSuccessAndMsg(Map<String,Object> msg){
//        return ImmutableMap.of(SUCCESS, true,MSG, msg);
//    }
//    /**
//     * 后台操作成功
//     */
//    public Map writeSuccess(){
//        return ImmutableMap.of(SUCCESS, true);
//    }
//
//    /**
//     * 上传文件成功
//     */
//    public void writeUploadSuccess(HttpServletResponse response) {
//        try {
//            response.setContentType("text/html");
//            response.getWriter().write("{success:true}");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    /**
//     * 上传文件失败
//     */
//    public void writeUploadFail(HttpServletResponse response) {
//        try {
//            response.setContentType("text/html");
//            response.getWriter().write("{success:false}");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
