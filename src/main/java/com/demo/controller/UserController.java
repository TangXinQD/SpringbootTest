package com.demo.controller;

import com.demo.domain.User;
import com.demo.domain.XYTS;
import com.demo.exception.UserException;
import com.demo.mapper.BannerMapper;
import com.demo.service.UserService;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TX
 */
@Slf4j
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

        userService.insert(user);
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

    /**
     *
     * @return
     */
    @ApiOperation(value="测试",httpMethod = "GET")
    @GetMapping("/test")
    public  Object test(Date date){

        RBloomFilter<String> rBloomFilter = redissonClient.getBloomFilter("testBloom", StringCodec.INSTANCE);
        rBloomFilter.tryInit(1000L, 0.01);
        rBloomFilter.add("ddd");
        rBloomFilter.add("ff");
        rBloomFilter.add("ee");

        System.out.println(rBloomFilter.contains("ddd"));
        System.out.println(rBloomFilter.contains("fffff"));
        System.out.println(rBloomFilter.contains("ddddddd"));

//        User byId = userService.findById(1);
        return null;
    }

    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        // 自定义一个dateFormat，前端传过来的是string形式的1550246400000，转换成date
        DateFormat dateFormat = new DateFormat() {
            @Override
            public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
                toAppendTo.append(date.getTime()+"");
                return toAppendTo;
            }

            @Override
            public Date parse(String source, ParsePosition pos) {
                Date date = new Date(Long.parseLong(source));
                pos.setIndex(source.length());
                return date;
            }
        };

        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
