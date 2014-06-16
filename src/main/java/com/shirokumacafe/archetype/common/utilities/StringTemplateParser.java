package com.shirokumacafe.archetype.common.utilities;

/**
 * 字符串模板工具转换类
 * Created with IntelliJ IDEA.
 * User: SHIROKUMA
 * Date: 13-8-28
 * Time: 上午11:23
 * To change this template use File | Settings | File Templates.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTemplateParser {
    private String pstartTag = "${";
    private String pendTag = "}";
    /**
     *
     * @param template 要解析的字符串
     * @param map 对应的值
     */
    public String parse(String template,Map<String,String> map){
        StringBuffer temp = new StringBuffer(template);
        Map<String,String> tagMap = this.getTagIndex(template);
        for(Map.Entry<String, String> entry:tagMap.entrySet()){
            //获得标识符
            String tag = entry.getValue();
            //获得替换的值，如果没有，则不变
            String repVal = map.get(entry.getKey())==null?entry.getValue():map.get(entry.getKey());
            //获得标识符在字符串中出现的次数
            int index = 0;
            //判断同一个标识符在字符串中出现的次数
            while((index=template.indexOf(tag,index))!=-1){
                //替换
                //System.out.println(tag+"位置:"+index);
                temp = temp.replace(temp.indexOf(tag), temp.indexOf(tag)+tag.length(), repVal);
                index += tag.length();
            }
        }
        return temp.toString();
    }
    /**
     * 获得key和对应的标识符如{age=${age}, name=${name}}
     * @param template
     */
    protected Map<String,String> getTagIndex(String template){
        Map<String,String> map = new HashMap<String,String>();
        Pattern pattern = Pattern.compile("\\$\\{[\\w]+\\}") ;
        Matcher matcher = pattern.matcher(template);
        int pstartLen = pstartTag.length();
        while(matcher.find()){
            //获得标示符
            String tag = matcher.group();
            //获得key
            String key = tag.substring(pstartLen, tag.lastIndexOf(pendTag));
            map.put(key, tag);
        }
        return map;
    }


    public static void main(String[] args) {
        String template = "${age} hi,${name},${name} are you ${age}?";
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "adam");
        map.put("age", "25");
        StringTemplateParser stp = new StringTemplateParser();
        System.out.println(stp.parse(template,map));
        System.out.println(stp.getTagIndex(template));
    }
}
