/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: RunnableQueue
 * Author:   TX
 * Date:     2018/11/19 21:50
 * Description: 任务队列
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.thread;

/**
 * 〈任务队列〉
 *
 * @author TX
 * @create 2018/11/19
 * @since 1.0.0
 */
public interface RunnableQueue {

    void offer(Runnable runnable);

    Runnable task();

    int size();


}