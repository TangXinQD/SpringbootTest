package com.demo.demo.location;

import cn.hutool.extra.pinyin.PinyinUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.demo.domain.GpLocationDO;
import com.demo.domain.GpLocationVO;
import com.demo.service.IGpLocationService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
class LocationTest {

    @Autowired
    private IGpLocationService gpLocationService;

    @Test
    void test(){
        List<GpLocationDO> list = gpLocationService.lambdaQuery()
                .eq(GpLocationDO::getType, 3).list();
        LinkedList<GpLocationVO> voList = Lists.newLinkedList();
        Map<String, List<GpLocationVO>> collect = list.stream().map(gpLocationDO -> {
            GpLocationVO vo = new GpLocationVO();
            BeanUtils.copyProperties(gpLocationDO, vo,"parentCode","sequence","type");
            vo.setPinyinName(PinyinUtil.getPinyin(gpLocationDO.getName(), ""));
            vo.setHeader(vo.getPinyinName().substring(0, 1).toUpperCase());
            return vo;
        })
                .sorted( (vo1,vo2) -> vo1.getHeader().compareTo(vo2.getHeader()))
                .sorted((vo1,vo2) -> vo1.getPinyinName().compareTo(vo2.getPinyinName())).collect(Collectors.groupingBy(GpLocationVO::getHeader));
        log.info("ping->{}", JSONObject.toJSONString(collect));
    }

}
