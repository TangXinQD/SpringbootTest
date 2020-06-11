package com.demo.service;

import com.demo.domain.User; /**
 * @Auther: TX
 * @Date: 2018/12/20 15:08
 * @Description:
 */
public interface UserService {

    int insert(User user);

    User findById(int i);
}
