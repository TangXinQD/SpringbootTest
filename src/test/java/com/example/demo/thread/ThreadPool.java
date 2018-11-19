/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ThreadPool
 * Author:   TX
 * Date:     2018/11/19 21:41
 * Description: 线程池
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.thread;

/**
 *
 * @author TX
 * @create 2018/11/19
 * @since 1.0.0
 */
public interface ThreadPool {

    void excute(Runnable runnable);

    void shutdown();

    int getInitSize();

    int getMaxSize();

    int getCoreSize();

    int getQueueSize();

    int getActiveCount();

    boolean isShutdown();

}