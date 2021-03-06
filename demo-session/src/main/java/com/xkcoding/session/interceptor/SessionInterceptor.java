package com.xkcoding.session.interceptor;

import com.xkcoding.session.constants.Consts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * 校验Session的拦截器
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-12-19 19:40
 */
@Component
@Slf4j
public class SessionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        final Object sessionAttribute = session.getAttribute(Consts.SESSION_KEY);
        if (sessionAttribute != null) {
            log.info("session: {}", sessionAttribute);
            return true;
        }
        // 跳转到登录页
        String url = "/page/login?redirect=true";
        response.sendRedirect(request.getContextPath() + url);
        return false;
    }
}
