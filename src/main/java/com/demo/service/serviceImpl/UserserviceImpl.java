package com.demo.service.serviceImpl;

import com.demo.domain.User;
import com.demo.listener.event.DemoApplicationEvent;
import com.demo.mapper.UserMapper;
import com.demo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: TX
 * @Date: 2018/12/20 15:36
 * @Description:
 */
@Service
public class UserserviceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ApplicationContext applicationContext;

    @Override
    public int insert(User user) {

        int id = userMapper.insert(user);

        applicationContext.publishEvent(new DemoApplicationEvent(this,user));
        return id;
    }

   /* @Async
    @EventListener(classes = {DemoApplicationEvent.class})
    public void onApplicationEvent(DemoApplicationEvent event) {

        User user = event.getUser();
        System.out.println("电风扇"+user.getId());

    }*/
}
