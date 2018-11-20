package com.example.controller;

import com.example.domain.User;
import com.example.exception.UserException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Api(value = "用户管理",description = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiOperation(value = "添加用户",notes = "根据User添加用户",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping("/add")
    public Object add(@RequestBody User user){



        Integer age = user.getAge();
        System.out.println(age);
        user.setAge(4);
        user.setName("aja");
        return user;
    }

    @ApiOperation(value = "添加用户",notes = "根据User添加用户",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
//                @ApiImplicitParam(name = "age", value = "age", required = true, dataType = "Long", paramType = "query"),
                @ApiImplicitParam(name = "name", value = "book's date", required = false, dataType = "string", paramType = "form")})
    @PostMapping("/add/to")
    public Object addUser(@RequestParam Integer age ,String name){

        System.out.println(age+name);

        Map<String,Object> map = new LinkedHashMap<>();

        map.put("id",1);


        return map;
    }

    @ApiOperation(value="修改用户",httpMethod = "POST")
    @PostMapping("/update")
    public  Object update(@RequestBody User user){
        String userName = user.getName();
        System.out.println(userName);

        return null;
    }


    @ApiOperation(value="查询用户",httpMethod = "GET")
    @GetMapping("/{id}")
    public  Object findOne(@PathVariable Long id) throws UserException {
        logger.info("id:{}",id);
        throw new UserException("errorCode","Do not find user!!");
    }
}
