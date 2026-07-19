package com.url.shortener.config;

import com.url.shortener.service.RateLimitService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class RateLimitInterceptor implements HandlerInterceptor {

    private final RateLimitService rateLimitService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String ip = request.getRemoteAddr();

        boolean allowed = rateLimitService.isAllowed(ip);

        if (!allowed) {

            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());

            response.getWriter().write("Too Many Requests");

            return false;
        }

        return true;
    }
}