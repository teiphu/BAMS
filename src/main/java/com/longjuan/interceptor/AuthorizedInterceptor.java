package com.longjuan.interceptor;

import com.longjuan.domain.Customer;
import com.longjuan.util.BamsConstants;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizedInterceptor implements HandlerInterceptor {

    private static final String[] IGNORE_URI = {"/loginForm", "/login","/404.html"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        String servletPath = request.getServletPath();
        for (String s : IGNORE_URI) {
            if (servletPath.contains(s)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            Customer customer = (Customer) request.getSession().getAttribute(BamsConstants.CUSTOMER_SESSION);
            if (customer == null) {
                request.setAttribute("message", "请先登录再访问网站!");
                request.getRequestDispatcher(BamsConstants.LOGIN).forward(request, response);
                return flag;
            } else {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
