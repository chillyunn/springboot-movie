package com.kit.movie.web.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("log filter init");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("log filter doFilter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestURI = httpServletRequest.getRequestURI();

        // 요청을 구분하기 위해 uuid 생성
        String uuid = UUID.randomUUID().toString();

        try{
            log.info("REQUEST[{}{}{}]", uuid, request.getDispatcherType(),requestURI);
            // 필터가 있으면 다음 필터가 계속해서 호출되고, 없으면 서블릿이 호출됨
            chain.doFilter(request,response);
        }catch (Exception e){
            throw e;
        }finally {
            //log.info("RESPONSE[{} {}]", uuid, requestURI);
            MDC.put("response",requestURI);
            log.info("RESPONSE[{}]", requestURI);
        }

    }
    @Override
    public void destroy() {
        log.info("log filter destroy");
    }
}
