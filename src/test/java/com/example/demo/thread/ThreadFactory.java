/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ThreadFactory
 * Author:   TX
 * Date:     2018/11/19 21:52
 * Description: 任务工厂
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.thread;

/**
 * 〈线程工厂〉
 *
 * @author TX
 * @create 2018/11/19
 * @since 1.0.0
 */
@FunctionalInterface
public interface ThreadFactory {


    Thread createThread(Runnable runnable);

}