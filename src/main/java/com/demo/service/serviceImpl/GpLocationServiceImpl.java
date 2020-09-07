package com.demo.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.domain.GpLocationDO;
import com.demo.mapper.GpLocationMapper;
import com.demo.service.IGpLocationService;
import org.springframework.stereotype.Service;

@Service
public class GpLocationServiceImpl extends ServiceImpl<GpLocationMapper, GpLocationDO> implements IGpLocationService {
}
