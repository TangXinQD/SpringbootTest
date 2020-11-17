package com.demo.strategy;

import com.google.common.collect.Lists;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("WkCourse")
@Order(2)
public class WkCourseProductStrategy implements ProductStrategy {
    @Override
    public boolean isSupport(Integer type, Integer oldProduct) {
        return type == 2;
    }

    @Override
    public List<Object> buildSku(Object object) {
        System.out.println("微课套餐创建！");
        return Lists.newLinkedList();
    }
}
