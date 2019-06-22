package com.itcast.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        HttpSession session = request.getSession();

        Object user = session.getAttribute("user");

        if (user==null){
            response.sendRedirect(request.getContextPath()+"/html/login.html");

            return false;
        }


        return true;
    }
}
