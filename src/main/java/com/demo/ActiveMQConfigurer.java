/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ActiveMQConfigurer
 * Author:   TX
 * Date:     2019/3/26 15:14
 * Description: activeMq\
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 *//*

package com.demo;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

*/
/**
 *
 * 〈activeMq\〉
 *
 * @author TX
 * @create 2019/3/26
 * @since 1.0.0
 *//*

//@Configuration
//@EnableJms
public class ActiveMQConfigurer {


    */
/**
     * 消息重发协议
     * @return
     *//*

//    @Bean
    public RedeliveryPolicy redeliveryPolicy(){
        RedeliveryPolicy  redeliveryPolicy=   new RedeliveryPolicy();
        //是否在每次尝试重新发送失败后,增长这个等待时间
        redeliveryPolicy.setUseExponentialBackOff(true);
        //重发次数,默认为6次   这里设置为10次
//        redeliveryPolicy.setMaximumRedeliveries(10);
        //重发时间间隔,默认为1秒
        redeliveryPolicy.setInitialRedeliveryDelay(1);
        //第一次失败后重新发送之前等待500毫秒,第二次失败再等待500 * 2毫秒,这里的2就是value
        redeliveryPolicy.setBackOffMultiplier(2);
        //是否避免消息碰撞
        redeliveryPolicy.setUseCollisionAvoidance(false);
        //设置重发最大拖延时间-1 表示没有拖延只有UseExponentialBackOff(true)为true时生效
        redeliveryPolicy.setMaximumRedeliveryDelay(-1);
        return redeliveryPolicy;
    }


//    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory (@Value("${activemq.url}")String url, RedeliveryPolicy redeliveryPolicy){
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory(
                        "admin",
                        "admin",
                        url);
        activeMQConnectionFactory.setRedeliveryPolicy(redeliveryPolicy);
        return activeMQConnectionFactory;
    }

//    @Bean("jmsQueueTemplate")
    public JmsTemplate jmsQuequTemplate(ActiveMQConnectionFactory activeMQConnectionFactory){
        JmsTemplate jmsTemplate=new JmsTemplate();
        jmsTemplate.setDeliveryMode(2);//进行持久化配置 1表示非持久化，2表示持久化
        jmsTemplate.setConnectionFactory(activeMQConnectionFactory);
//        jmsTemplate.setDefaultDestination(queue); //此处可不设置默认，在发送消息时也可设置队列
        jmsTemplate.setSessionAcknowledgeMode(4);//客户端签收模式
        jmsTemplate.setPubSubDomain(false);
        return jmsTemplate;
    }

//    @Bean("jmsTopicTemplate")
    public JmsTemplate jmsTopicTemplate(ActiveMQConnectionFactory activeMQConnectionFactory){
        JmsTemplate jmsTemplate=new JmsTemplate();
        jmsTemplate.setDeliveryMode(2);//进行持久化配置 1表示非持久化，2表示持久化
        jmsTemplate.setConnectionFactory(activeMQConnectionFactory);
//        jmsTemplate.setDefaultDestination(queue); //此处可不设置默认，在发送消息时也可设置队列
        jmsTemplate.setSessionAcknowledgeMode(4);//客户端签收模式
        jmsTemplate.setPubSubDomain(true);
        return jmsTemplate;
    }



    //定义一个消息监听器连接工厂，这里定义的是点对点模式的监听器连接工厂
//    @Bean(name = "jmsQueueListener")
    public DefaultJmsListenerContainerFactory jmsQueueListenerContainerFactory(ActiveMQConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(activeMQConnectionFactory);
        //设置连接数
        factory.setConcurrency("1-10");
        //重连间隔时间
        factory.setRecoveryInterval(1000L);
        factory.setSessionAcknowledgeMode(4);
        factory.setPubSubDomain(false);
        return factory;
    }

    //定义一个消息监听器连接工厂，这里定义的是点对点模式的监听器连接工厂
//    @Bean(name = "jmsTopicListener")
    public DefaultJmsListenerContainerFactory jmsTopicListenerContainerFactory(ActiveMQConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(activeMQConnectionFactory);
        //设置连接数
        factory.setConcurrency("1-10");
        //重连间隔时间
        factory.setRecoveryInterval(1000L);
        factory.setSessionAcknowledgeMode(4);
        factory.setPubSubDomain(true);
        factory.setMaxMessagesPerTask(1);
        return factory;
    }


}
*/
