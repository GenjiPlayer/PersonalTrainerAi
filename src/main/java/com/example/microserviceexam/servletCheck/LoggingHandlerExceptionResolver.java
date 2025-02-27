package com.example.microserviceexam.servletCheck;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class LoggingHandlerExceptionResolver implements HandlerExceptionResolver, Ordered {
    public int getOrder() {
        return Integer.MIN_VALUE;
    }

    public ModelAndView resolveException(
            HttpServletRequest aReq, HttpServletResponse aRes,
            Object aHandler, Exception anExc
    ) {
        anExc.printStackTrace();
        return null;
    } //copy paste fra stackoverflow, finn link senere
}
