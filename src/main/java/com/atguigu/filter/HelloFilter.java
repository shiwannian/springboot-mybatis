package com.atguigu.filter;


import javax.servlet.*;
import java.io.IOException;

public class HelloFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("HelloFilter............放行之前");

        System.out.println("HelloFilter............放行之后");
    }

    @Override
    public void destroy() {

    }
}
