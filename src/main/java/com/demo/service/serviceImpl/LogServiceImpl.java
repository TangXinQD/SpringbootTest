package com.demo.service.serviceImpl;

import com.demo.domain.Log;
import com.demo.mapper.LogMapper;
import com.demo.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: TX
 * @Date: 2019/1/25 14:07
 * @Description:
 */
@Service
public class LogServiceImpl implements LogService {

    @Resource
    private LogMapper logMapper;


    @Override
    public void insert(Log log) {
        logMapper.insert(log);
    }
}
