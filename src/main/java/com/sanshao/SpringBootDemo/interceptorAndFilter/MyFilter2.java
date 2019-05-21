package com.sanshao.SpringBootDemo.interceptorAndFilter;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(2)
public class MyFilter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("before filter2");
        chain.doFilter(request,response);
        System.out.println("after filter2");
    }

    @Override
    public void destroy() {

    }
}
