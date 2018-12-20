package com.demo.demo;

/**
 * @Auther: TX
 * @Date: 2018/10/17 0017 14:55
 * @Description:多线程测试
 */
public class ThreadGroupTest {


    public static void  main(String [] args){

        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();

        ThreadGroup threadGroup1 = new ThreadGroup("group1");//未指定父

        System.out.println(threadGroup == threadGroup1.getParent());

        ThreadGroup threadGroup2 = new ThreadGroup(threadGroup1,"group1");//指定父


        System.out.println(threadGroup2.getParent() == threadGroup1);


        Thread thread = new Thread(threadGroup,()->{

        });

    }
}
