package com.demo.strategy;

import com.google.common.collect.Lists;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("shop")
@Order(1)
public class ShopProductStrategy implements ProductStrategy {
    @Override
    public boolean isSupport(Integer type, Integer oldProduct) {
        return type == 1 && oldProduct == 1;
    }

    @Override
    public List<Object> buildSku(Object object) {
        System.out.println("电商产品创建！");
        return Lists.newLinkedList();
    }
}
