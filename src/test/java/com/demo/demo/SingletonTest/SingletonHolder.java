package com.demo.demo.SingletonTest;

/**
 * @Auther: TX
 * @Date: 2018/11/20 0020 16:04
 * @Description: Holder方式单例
 */
public final class SingletonHolder {


    private byte[] data = new byte[1024];

    private SingletonHolder() {
    }

    //静态 实例 ， 直接被初始化
    private static  class  Holder{
        private static  SingletonHolder instance = new SingletonHolder();
    }

    //获得holder的静态属性
    public static SingletonHolder getInstance(){
        return Holder.instance;
    }
}
