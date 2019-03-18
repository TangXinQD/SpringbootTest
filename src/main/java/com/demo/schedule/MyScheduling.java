package com.demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: TX
 * @Date: 2019/3/15 10:22
 * @Description: 定时任务
 */

@Component
public class MyScheduling {


    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron = "0 1/1 * * * ?")
    public void  task(){
        System.out.println("crom 定时任务启动"+sdf.format(new Date(System.currentTimeMillis())));
    }

    @Scheduled(fixedRate = 5000)
//    @Scheduled(fixedDelay = 5000)
//    @Scheduled(initialDelay=1000, fixedRate=5000)
    public void  taskZone(){
        System.out.println("fixedRate 定时任务启动"+sdf.format(new Date(System.currentTimeMillis())));
    }
}
