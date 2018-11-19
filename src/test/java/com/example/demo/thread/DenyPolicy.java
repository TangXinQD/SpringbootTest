/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: DenyPolicy
 * Author:   TX
 * Date:     2018/11/19 21:57
 * Description: 策略
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.thread;

/**
 * 〈策略〉
 *
 * @author TX
 * @create 2018/11/19
 * @since 1.0.0
 */
@FunctionalInterface
public interface DenyPolicy {


    void reject(Runnable runnable, ThreadPool threadPool);

    //将任务丢弃
    class DiscardPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            //do nothing!
        }
    }

    //抛出异常通知
    class AbortPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {

//            throw new RunnableDenyException("This runnable is be abort! name :" + runnable);
        }
    }




}