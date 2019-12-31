package com.qdu.interceptor;

import com.qdu.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 配置拦截器的具体实现
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 通过request对象获取session
        HttpSession session = request.getSession();
        // 判断session中是否有登录用户
        User user = (User) session.getAttribute("user");
        // 如果用户为空，则跳转到登录页面
        if (ObjectUtils.isEmpty(user)) {
            String contexPath = request.getContextPath();
            response.sendRedirect(contexPath + "/user/to_login");
            return false;
        }
        return true;
    }
}
