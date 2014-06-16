package com.shirokumacafe.archetype.common.filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * XSS过滤器
 * @author lim
 */
public class XssFilter extends BaseFilter {

    @Override
    public void init() throws ServletException {
        FilterConfig filterConfig = getConfig();
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new XssRequestWrapper(request), response);
    }

    @Override
    public void destroy() {
    }
}
