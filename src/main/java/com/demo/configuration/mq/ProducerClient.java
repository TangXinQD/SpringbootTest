package com.demo.configuration.mq;

import com.aliyun.openservices.ons.api.bean.ProducerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 生产者配置
 * @version: 1.0
 * @date: 2020/6/6 9:54 上午
 * @author: TX
 **/
@Configuration
public class ProducerClient {

    @Autowired
    private RocketMqProperties mqProperties;

    @Bean(initMethod = "start", destroyMethod = "shutdown")
    public ProducerBean buildProducer() {
        ProducerBean producer = new ProducerBean();
        producer.setProperties(mqProperties.getMqProperties());
        return producer;
    }

}
