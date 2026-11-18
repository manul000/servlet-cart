package com.study.shop.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class RequestFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpServletRequest r = (HttpServletRequest) request;
        System.out.println(r.getMethod() + " " + r.getRequestURI());
        chain.doFilter(request, response);
    }
}
