package com.demo.service.serviceImpl;

import com.demo.domain.User;
//import com.demo.listener.event.DemoApplicationEvent;
import com.demo.mapper.UserMapper;
import com.demo.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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

//
        return id;
    }

    @Cacheable(cacheNames = "user",key = "#id")
    @Override
    public User findById(int id) {
        User user = new User();
        user.setId(1L);
        user.setUserName("111");
        user.setComment("2的叫法打架了");
        user.setCreateTime(new Date());
        user.setLastModifyTime(new Date());
        return user;
    }

   /* @Async
    @EventListener(classes = {DemoApplicationEvent.class})
    public void onApplicationEvent(DemoApplicationEvent event) {

        User user = event.getUser();
        System.out.println("电风扇"+user.getId());

    }*/
}
