package org.lk.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class SessionIdInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String sessionIdHeader = request.getHeader("SESSION-ID");
        System.out.println("SessionID: " + sessionIdHeader);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        return true; // true - запрос прошел проверку, false - нет
    }

}
