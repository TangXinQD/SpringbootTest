/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: JmsReceiver
 * Author:   TX
 * Date:     2019/3/26 16:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 *//*

package com.demo.Jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

*/
/**
 *
 * 〈〉
 *
 * @author TX
 * @create 2019/3/26
 * @since 1.0.0
 *//*

@Component
public class JmsReceiver {


    @JmsListener(destination = "queue_user",containerFactory = "jmsQueueListener")
    public void receiveQueue(final TextMessage textMessage , Session session) throws JMSException {

        try {
            System.out.println(textMessage.getText());
            textMessage.acknowledge();
        } catch (JMSException e) {
            session.recover();
        }
    }

    @JmsListener(destination = "topic_user",containerFactory = "jmsTopicListener")
    public void receiveTopic1(final TextMessage textMessage , Session session) throws JMSException {

        try {
            System.out.println(textMessage.getText());
            textMessage.acknowledge();
        } catch (JMSException e) {
            session.recover();
        }
    }

    @JmsListener(destination = "topic_user",containerFactory = "jmsTopicListener")
    public void receiveTopic2(final TextMessage textMessage , Session session) throws JMSException {

        try {
            System.out.println(textMessage.getText());
            textMessage.acknowledge();
        } catch (JMSException e) {
            session.recover();
        }
    }
}
*/
