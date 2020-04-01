/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ThreadPoolTest
 * Author:   TX
 * Date:     2019/4/9 16:53
 * Description: 线程池测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.demo.thread.threadPool;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.concurrent.*;

/**
 *
 * 〈线程池测试〉
 *
 * @author TX
 * @create 2019/4/9
 * @since 1.0.0
 */
public class ThreadPoolTest {

    private static ExecutorService exs = Executors.newFixedThreadPool(3);

//    private static ExecutorService exsC = Executors.newCachedThreadPool();
//
//    private static ExecutorService exsS = Executors.newSingleThreadExecutor();
//
//    private static ExecutorService exsSch = Executors.newScheduledThreadPool(4);



    public static void main(String [] args){
//        executorTest();
        futureTaskTest();
    }

    private static void futureTaskTest() {
        FutureTask<String> task1 = new FutureTask<String>(()->{
            System.out.println("FutureTask1运行："+Thread.currentThread().getName());
            return Thread.currentThread().getName();
        });

        FutureTask<String> task2 = new FutureTask<String>(()->{
            System.out.println("FutureTask2运行："+Thread.currentThread().getName());
            return Thread.currentThread().getName();
        });

        exs.execute(task1);
        exs.execute(task2);

        while (true){


            try {
                if(task1.isDone() && task2.isDone()){
                    System.out.println("taskDone");
                    exs.shutdown();
                    return;
                }

                if(!task1.isDone()){ // 任务1没有完成，会等待，直到任务完成
                    System.out.println("FutureTask1 output="+task1.get());
                }

                System.out.println("Waiting for FutureTask2 to complete");
                String s = task2.get(200L, TimeUnit.MILLISECONDS);

                if(s !=null){
                    System.out.println("FutureTask2 output="+s);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }

        }
    }

    private static void executorTest() {
        for (int i = 0 ; i <= 10 ; i++){
            exs.execute(()-> {System.out.println(Thread.currentThread().getName()+"线程运行！");});
        }
    }

}
