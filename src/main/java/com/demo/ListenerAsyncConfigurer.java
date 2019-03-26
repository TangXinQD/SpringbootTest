package com.demo;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;


/**
 * @Auther: TX
 * @Date: 2019/3/21 17:18
 * @Description:
 **/


@Configuration
@EnableAsync
public class ListenerAsyncConfigurer implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(8);
        executor.setMaxPoolSize(42);
        executor.setQueueCapacity(11);//阻塞队列容量
        executor.setThreadNamePrefix("ExecutorName-");
        executor.initialize();
        return executor;
    }




    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {

        return (Throwable ex, Method method, Object... params) -> {
            System.out.println("异步方法未处理异常:"+ex.getMessage()+",method:"+method.getName());
        };
    }
}




