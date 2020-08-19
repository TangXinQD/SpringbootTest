package com.demo.service.serviceImpl;

import com.demo.domain.Banner;
import com.demo.mapper.BannerMapper;
import com.demo.service.BannerService;
import com.demo.util.annotation.SystemServiceLog;
import com.lianlian.lib.mq.client.MqProducerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: TX
 * @Date: 2018/12/20 17:27
 * @Description:
 */
@Service
public class BannerServiceImpl  implements BannerService{
    @Resource
    private BannerMapper bannerMapper;

    @Autowired
    private MqProducerClient producerClient;

    @SystemServiceLog(description = "bannerService")
    @Override
    public int insert(Banner banner) throws Exception{
        if(banner != null)
            throw new Exception("ddd");
        return bannerMapper.insert(banner);
    }
}
