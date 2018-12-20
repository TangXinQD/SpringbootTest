package com.demo.exception;

/**
 * @Auther: TX
 * @Date: 2018/11/20 0020 17:28
 * @Description:
 */
public class UserException extends  RuntimeException {

    public UserException (String msg){
        super(msg);
    }

    public UserException (String code, String msg){
        super(code, new Throwable(msg));
    }
}
