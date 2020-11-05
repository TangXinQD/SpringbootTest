package com.demo.controller;

import com.demo.domain.Banner;
import com.demo.service.BannerService;
import com.demo.service.TransactionTestService;
import com.demo.util.annotation.SystemControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author tangxin
 * @Date: 2018/12/20 17:19
 * @Description:
 */
@Api(value = "banner管理",description = "banner管理")
@RequestMapping("/banner")
@RestController
public class BannerController {
    private Logger logger = LoggerFactory.getLogger(BannerController.class);

    @Resource
    private BannerService bannerService;

    @SystemControllerLog(description = "bannerController",value = "#banner.title")
    @ApiOperation(value = "添加banner",notes = "添加banner",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public Object add(@RequestBody  Banner banner) throws Exception{
        return bannerService.insert(banner);

    }

    @Resource
    private TransactionTestService transactionTestService;

    @GetMapping("/testA")
    public Object testA() throws Exception{
         transactionTestService.A();
        return null;
    }

    @GetMapping("/testC")
    public Object testC() throws Exception{
        transactionTestService.C();
        return null;
    }

    @GetMapping("/testB")
    public Object testB() throws Exception{
        transactionTestService.B();
        return null;
    }

}
