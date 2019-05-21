package com.sanshao.SpringBootDemo.interceptorAndFilter;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(1)
public class MyFilter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("before filter1");
        chain.doFilter(request,response);
        System.out.println("after filter1");
    }

    @Override
    public void destroy() {

    }
}
