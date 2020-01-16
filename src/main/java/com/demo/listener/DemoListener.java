/*
package com.demo.listener;

import com.demo.Jms.JmsSender;
import com.demo.domain.User;
import com.demo.listener.event.DemoApplicationEvent;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

*/
/**
 * @Auther: TX
 * @Date: 2019/3/21 15:37
 * @Description:
 *//*

@Component
public class DemoListener implements ApplicationListener<DemoApplicationEvent> {

    @Autowired
    private JmsSender jmsSender;

    */
/**
     * 监听
     * @param event
     *//*

    @Async
    @Override
    public void onApplicationEvent(DemoApplicationEvent event) {

        User user = event.getUser();
        Object source = event.getSource();
        System.out.println(user.getId()+"监听器,ThreadName:"+Thread.currentThread().getName());
        jmsSender.sendMessage(new ActiveMQTopic("topic_user"), user.getId()+user.getUserName());
    }
}
*/
