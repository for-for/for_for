package jiaobantao.web.interceptors;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Log every url
 *
 * By extends HandlerInterceptorAdapter instead of implementing HandlerInterceptor,
 * you can override only the methods that you need.
 */
public class LogInterceptor extends HandlerInterceptorAdapter {
    /**
     * before
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.format("<debug info> LogInterceptor preHandle() %s\n", request.getRequestURI());

        return true; // make execution chain continue by returning true
    }
}
