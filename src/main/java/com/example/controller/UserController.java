package com.example.controller;

import com.example.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户管理",description = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {


    @ApiOperation(value = "添加用户",notes = "根据User添加用户",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true,dataType = "user")
    @RequestMapping("/add")
    public void add( User user){

        Integer age = user.getAge();
        System.out.println(age);
    }

    @ApiOperation(value="修改用户",httpMethod = "POST")
    @RequestMapping("/update")
    public  void update(User user){
        String userName = user.getName();
        System.out.println(userName);
    }
}
