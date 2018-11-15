package com.example.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: TX
 * @Date: 2018/10/25 0025 17:37
 * @Description: 统一异常处理
 */

@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(RuntimeException.class)
    public Object globalException(HttpServletRequest request , RuntimeException run){


        return  null;
    }

}
