package com.base.wang.web;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class MyFilter extends HttpServlet implements Filter {
    private String encoding=null;
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding=filterConfig.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        filterChain.doFilter(request,response);
        response.setCharacterEncoding(encoding);
        System.out.println("--asd第三方的");
        System.out.println(response);
    }
}
