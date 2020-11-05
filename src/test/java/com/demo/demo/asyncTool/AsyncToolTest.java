/*
package com.demo.demo.asyncTool;

import com.jd.platform.async.callback.ICallback;
import com.jd.platform.async.callback.IWorker;
import com.jd.platform.async.executor.Async;
import com.jd.platform.async.executor.timer.SystemClock;
import com.jd.platform.async.worker.WorkResult;
import com.jd.platform.async.wrapper.WorkerWrapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ExecutionException;

*/
/**
 * @description: AsyncToolTest
 * @date: 2020/7/10 4:49 下午
 * @author: TX
 * @version: 1.0
 *//*

@Slf4j
public class AsyncToolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        parallelWorker();

        arrangeWorker();



    }

    private static void arrangeWorker() throws ExecutionException, InterruptedException {
        IWorkDemo a = new IWorkDemo();
        IWorkDemo b = new IWorkDemo();
        IWorkDemo c = new IWorkDemo();
        IWorkDemo d = new IWorkDemo();


        WorkerWrapper<String,String> workerWrapperA = new WorkerWrapper.Builder<String,String>()
                .worker(a)
                .callback(a)
                .param("a")
                .build();

        WorkerWrapper<String,String> workerWrapperD = new WorkerWrapper.Builder<String,String>()
                .worker(d)
                .callback(d)
                .param("d")
                .build();

        WorkerWrapper<String,String> workerWrapperB = new WorkerWrapper.Builder<String,String>()
                .worker(b)
                .callback(b)
                .param("b")
                .depend(workerWrapperA)
                .next(workerWrapperD)
                .build();

        WorkerWrapper<String,String> workerWrapperC = new WorkerWrapper.Builder<String,String>()
                .worker(c)
                .callback(c)
                .param("c")
                .depend(workerWrapperA)
                .next(workerWrapperD)
                .build();

        Async.beginWork(3100,workerWrapperA);

        System.out.println(Async.getThreadCount());

        Async.shutDown();
    }

    */
/**
     * @description  并行
     *               1
     *               2
     *               3
     * @version 1.0 
     * @date 2020/8/21 2:48 下午 
     * @author TX 
     **//*

    private static void parallelWorker() throws ExecutionException, InterruptedException {
        IWorkDemo w1 = new IWorkDemo();
        IWorkDemo w2 = new IWorkDemo();
        IWorkDemo w3 = new IWorkDemo();


        WorkerWrapper<String, String> workerWrapper1 = new WorkerWrapper.Builder<String, String>()
                .worker(w1)
                .callback(w1)
                .param("1")
                .build();

        WorkerWrapper<String, String> workerWrapper2 = new WorkerWrapper.Builder<String, String>()
                .worker(w2)
                .callback(w2)
                .param("2")
                .build();

        WorkerWrapper<String, String> workerWrapper3 = new WorkerWrapper.Builder<String, String>()
                .worker(w3)
                .callback(w3)
                .param("3")
                .build();

        Async.beginWork(1500,workerWrapper1,workerWrapper2,workerWrapper3);

        System.out.println(Async.getThreadCount());
        System.out.println(workerWrapper3.getWorkResult());

        Async.shutDown();
    }

    static class IWorkDemo implements IWorker<String,String>, ICallback<String,String> {

        @Override
        public String action(String object, Map<String, WorkerWrapper> allWrappers) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "result = " + SystemClock.now() + "---param = " + object + " from 1";
        }

        @Override
        public String defaultValue() {
            return "worker1--default";
        }

        @Override
        public void begin() {
            System.out.println(Thread.currentThread().getName() + "- start --" + System.currentTimeMillis());
        }

        @Override
        public void result(boolean success, String param, WorkResult<String> workResult) {
            if (success) {
                System.out.println("callback worker1 success--" + SystemClock.now() + "----" + workResult.getResult()
                        + "-threadName:" +Thread.currentThread().getName());
            } else {
                System.err.println("callback worker1 failure--" + SystemClock.now() + "----"  + workResult.getResult()
                        + "-threadName:" +Thread.currentThread().getName());
            }
        }

    }

}
*/
