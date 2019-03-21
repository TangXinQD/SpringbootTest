package com.demo.listener.event;

import com.demo.domain.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @Auther: TX
 * @Date: 2019/3/21 15:15
 * @Description: 事件
 */
@Getter
public class DemoApplicationEvent extends ApplicationEvent {

    private User user;

    public DemoApplicationEvent(Object source,User user) {
        super(source);
        this.user = user;
    }
}
