package com.shirokumacafe.archetype.common.filter;

import org.owasp.esapi.ESAPI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * xss装饰处理
 *
 * @author lim
 */
public class XSSRequestWrapper extends HttpServletRequestWrapper{
    public XSSRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if( null == value ){
            return null;
        }
        return ESAPI.encoder().encodeForHTML(value);
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if( null == values ){
            return null;
        }
        String[] encodedValues = new String[values.length];
        for(int i=0;i<values.length;i++ ){
            encodedValues[i] = ESAPI.encoder().encodeForHTML(values[i]);
        }
        return encodedValues;
    }
}
