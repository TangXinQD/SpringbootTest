package com.demo.demo.LambdaDemo;

import java.io.Serializable;
import java.util.Optional;

/**
 * @Auther: TX
 * @Date: 2018/10/22 0022 16:02
 * @Description:
 */
public class User implements Serializable{

    private static final long serialVersionUID =-1L;
    private String userName;

    private Integer age;

    /**
     *
     */
    private Optional<Role> role;

    public Optional<Role> getRole() {
        return role;
    }

    public void setRole(Optional<Role> role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
