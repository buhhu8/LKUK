package org.lk.config;

import org.lk.interceptor.SessionCreateInterceptor;
import org.lk.interceptor.SessionIdInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private SessionIdInterceptor sessionIdInterceptor;
    @Autowired
    private SessionCreateInterceptor sessionCreateInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionIdInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/v1/authorization/**");
        registry.addInterceptor(sessionCreateInterceptor)
                .addPathPatterns("/api/v1/authorization/**");
        //api/v1/authorization
    }

}
