package com.demo.service.serviceImpl;

import com.demo.domain.User;
import com.demo.mapper.UserMapper;
import com.demo.service.UserService;
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

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }
}
