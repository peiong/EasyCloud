package com.peirong.interceptor;

import com.peirong.entity.User;
import com.peirong.utils.UserHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 获取session
        HttpSession session = request.getSession();

        // 获取session的用户
        Object user = session.getAttribute("user");

        // 判断用户是否存在
        if (user == null) {
            response.setStatus(401);
            return false;
        }

        UserHolder.saveUser((User) user);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 移除用户
        UserHolder.removeUser();
    }
}
