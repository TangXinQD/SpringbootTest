package com.demo.listener;

import com.demo.domain.User;
import com.demo.listener.event.DemoApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: TX
 * @Date: 2019/3/21 15:37
 * @Description:
 */

@Component
public class DemoListener implements ApplicationListener<DemoApplicationEvent> {

    /**
     * 监听
     * @param event
     */
    @Override
    public void onApplicationEvent(DemoApplicationEvent event) {

        User user = event.getUser();
        Object source = event.getSource();

        System.out.println(user.getId()+"监听器");
    }
}
