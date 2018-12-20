package com.demo.demo.SingletonTest;

/**
 * @Auther: TX
 * @Date: 2018/11/20 0020 16:23
 * @Description: 枚举形式单例(枚举代替holder)
 */
public class SingletonEnum {


    private byte[] data = new byte[1024];

    private SingletonEnum() {
    }

    private enum HolderEnum{

        INSTANCE;

        private SingletonEnum instance;

        HolderEnum() {
            this.instance = new SingletonEnum();
        }

        private SingletonEnum getInstance() {
            return instance;
        }
    }


    public static SingletonEnum getInstance() {

        return HolderEnum.INSTANCE.getInstance();
    }
}
