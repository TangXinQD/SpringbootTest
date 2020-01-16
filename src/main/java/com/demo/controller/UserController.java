package com.demo.controller;

import com.demo.domain.User;
import com.demo.domain.XYTS;
import com.demo.exception.UserException;
import com.demo.mapper.BannerMapper;
import com.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Api(value = "用户管理",description = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     *
     * @param user 用户信息
     * @return result
     */
    @ApiOperation(value = "添加用户",notes = "根据User添加用户",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping("/add")
    public Object add(@RequestBody User user){
        userService.insert(user);
        return user.getId();
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
        String userName = user.getUserName();
        System.out.println(userName);

        return null;
    }


    /**
     *
     * @param id
     * @return
     * @throws UserException
     */
    @ApiOperation(value="查询用户",httpMethod = "GET")
    @GetMapping("/{id}")
    public  Object findOne(@PathVariable Long id) throws UserException {
        logger.info("id:{}",id);
        LocalDateTime time = LocalDateTime.now();
        throw new UserException("errorCode","Do not find user!!");
    }

}
