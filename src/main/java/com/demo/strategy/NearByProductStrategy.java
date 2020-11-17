package com.demo.strategy;

import com.google.common.collect.Lists;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("nearBy")
@Order(3)
public class NearByProductStrategy implements ProductStrategy {
    @Override
    public boolean isSupport(Integer type, Integer oldProduct) {
        return true;
    }

    @Override
    public List<Object> buildSku(Object object) {
        System.out.println("周边游套餐创建！");
        return Lists.newLinkedList();
    }
}
