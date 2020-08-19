package com.demo.demo.thread.completableFuture;

import org.springframework.scheduling.quartz.SimpleThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @author TX
 * @version 1.0
 * @description CompletableFutureDemo
 * @date 2020/8/19 9:49 上午
 */
public class CompletableFutureDemo {

    private static final Executor executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return "here";
        }, executor)
                .thenApplyAsync(result -> {
                    System.out.println(result + "1");
                    return result + "1";
                })
                .thenApplyAsync(result -> {
                    System.out.println(result + "1");
                    return result + "1";
                });
        System.out.println("join");
        String s = stringCompletableFuture.get();
        System.out.println(s);
    }
}

