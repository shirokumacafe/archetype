package com.shirokumacafe.archetype.common.security.filter;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * xss装饰处理
 *
 * @author lim
 */
public class XssRequestWrapper extends HttpServletRequestWrapper{

    private final static Whitelist MY_WHITE_LIST = Whitelist.relaxed();

    public XssRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if( null == value ){
            return null;
        }
        return clean(value);
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if( null == values ){
            return null;
        }
        String[] encodedValues = new String[values.length];
        for(int i=0;i<values.length;i++ ){
            encodedValues[i] = clean(values[i]);
        }
        return encodedValues;
    }

    private String clean(String str){
        if(StringUtils.isBlank(str)) return "";
        return Jsoup.clean(str,MY_WHITE_LIST);
    }
}
