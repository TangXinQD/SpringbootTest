package com.demo.demo;

import com.demo.txmap.CloudMapService;
import com.demo.txmap.model.LeaderMapDTO;
import com.demo.txmap.model.Location;
import com.demo.txmap.model.TencentMapDTO;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * @author TX
 * @version 1.0
 * @description CloudMapTest
 * @date 2020/8/24 2:17 下午
 */
@SpringBootTest
public class CloudMapTest {

    private final CloudMapService cloudMapService;

    @Autowired
    public CloudMapTest(CloudMapService cloudMapService) {
        this.cloudMapService = cloudMapService;
    }

    @Test
    void testSaveData() throws IOException {
        List<TencentMapDTO> list = Lists.newLinkedList();

        TencentMapDTO dto = new TencentMapDTO();
        dto.setUdId("1266814987");
        dto.setLocation(new Location(new BigDecimal("30.546125"),new BigDecimal("104.066459")));
        dto.setTitle("新希望国际B座");
        HashMap<Object, Object> map = Maps.newHashMap();
        map.put("address","一栋一单元");
        map.put("citycode","110100");
        map.put("headimg","一栋一单元");
        map.put("name","张");
        dto.setX(map);
        list.add(dto);

        /*TencentMapDTO dto = new TencentMapDTO();
        dto.setUdId("1266814988");
        dto.setLocation(new Location(new BigDecimal("39.983988"),new BigDecimal("116.307709")));
        dto.setTitle("海淀区苏州街营业部");
        HashMap<Object, Object> map = Maps.newHashMap();
        map.put("price","15.5");
        dto.setX(map);
        list.add(dto);*/

        Object o = cloudMapService.saveData("5f3e81a0f969d52d3f259197", list);
    }

    @Test
    void testSaveDataTest() throws IOException {
        List<TencentMapDTO> list = Lists.newLinkedList();

        TencentMapDTO dto = new TencentMapDTO();
        dto.setUdId("1266814988");
        dto.setLocation(new Location(new BigDecimal("39.983988"),new BigDecimal("116.307709")));
        dto.setTitle("海淀区苏州街营业部");
        HashMap<Object, Object> map = Maps.newHashMap();
        map.put("price","15.5");
        dto.setX(map);
        list.add(dto);

        /*TencentMapDTO dto = new TencentMapDTO();
        dto.setUdId("156987");
        dto.setLocation(new Location(new BigDecimal("30.546120"),new BigDecimal("104.066464")));
        dto.setTitle("新希望B座");
        HashMap<Object, Object> map = Maps.newHashMap();
        map.put("price","16.8");
        dto.setX(map);
        list.add(dto);*/

        Object o = cloudMapService.saveDataTest("5f43c84f1773c74f4548f0fa", list);
    }

    @Test
    void testGeoCoder() throws IOException {
        Object o = cloudMapService.geoCoder(new BigDecimal("30.546120"), new BigDecimal("104.066464"));
    }
}
