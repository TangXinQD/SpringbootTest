package com.example.controller;

import com.example.domain.ErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: TX
 * @Date: 2018/10/25 0025 17:37
 * @Description: 统一异常处理
 */
@RestControllerAdvice
public class GlobalExceptionController {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);

    @ExceptionHandler(Exception.class)
    public Object globalException(HttpServletRequest request , Exception e ){
        logger.info("code:{},msg :{}",e.getMessage(),e.getCause().getMessage());
        ErrorInfo<String> errorInfo = new ErrorInfo();
        errorInfo.setMessage(e.getCause().getMessage());
        //.....
        return  errorInfo;
    }
}
