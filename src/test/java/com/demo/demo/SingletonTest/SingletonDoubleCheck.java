package com.demo.demo.SingletonTest;


import java.net.Socket;
import java.sql.Connection;

/**
 * @Auther: TX
 * @Date: 2018/11/20 0020 14:53
 * @Description: DoubleCheck实现单例模式
 */
public final class SingletonDoubleCheck {

    private byte [] data = new byte[1024];

    //加 volatile
    private volatile static  SingletonDoubleCheck instance = null;


    Connection connection;

    Socket socket;

    private SingletonDoubleCheck() {
    }

    public static SingletonDoubleCheck getInstance() {

        //null 时，才进入同步代码块
        if(null == instance){

            synchronized (SingletonDoubleCheck.class){

                if(null == instance)
                    instance = new SingletonDoubleCheck();
            }
        }
        return  instance;
    }
}
