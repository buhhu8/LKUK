package org.lk.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SessionCreateInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (response.getStatus() == HttpServletResponse.SC_OK) {
            // должны в headed добавить session_id
            System.out.println();


            // 1 param - header name
            // 2 param - header value
            // response.addHeader();
        }
        System.out.println();
    }

}
