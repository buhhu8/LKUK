package org.lk.interceptor;

import lombok.RequiredArgsConstructor;
import org.lk.service.SessionService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class SessionIdInterceptor implements HandlerInterceptor {

    private final SessionService innerCacheSessionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String sessionIdHeader = request.getHeader("SESSION-ID");

        if (innerCacheSessionService.isExpired(sessionIdHeader)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        return true; // true - запрос прошел проверку, false - нет
    }

}
