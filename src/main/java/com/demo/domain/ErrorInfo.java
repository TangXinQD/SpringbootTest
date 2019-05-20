package com.demo.domain;

import lombok.Data;

/**
 * @Auther: TX
 * @Date: 2018/11/20 0020 17:10
 * @Description:
 */
@Data
public class ErrorInfo<T> {

    public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    private Integer code;
    private String message;
    private String url;
    private T data;


}