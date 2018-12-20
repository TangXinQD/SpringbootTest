package com.demo.service.serviceImpl;

import com.demo.domain.Banner;
import com.demo.mapper.BannerMapper;
import com.demo.service.BannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: TX
 * @Date: 2018/12/20 17:27
 * @Description:
 */
@Service
public class BannerImpl  implements BannerService{
    @Resource
    private BannerMapper bannerMapper;

    @Override
    public int insert(Banner banner) {
        return bannerMapper.insert(banner);
    }
}
