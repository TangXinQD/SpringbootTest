/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: JmsSend
 * Author:   TX
 * Date:     2019/3/26 16:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.Jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 *
 *
 * @author TX
 * @create 2019/3/26
 * @since 1.0.0
 */

@Component
public class JmsSender {


    @Autowired
    @Qualifier(value = "jmsTopicTemplate")
    private JmsTemplate jmsTemplate;

    public  void sendMessage(Destination destination, final Object msg){

        this.jmsTemplate.convertAndSend(destination,msg);
    }


}
