package com.demo.demo;

import com.demo.txmap.CloudMapService;
import com.demo.txmap.model.LeaderMapDTO;
import com.demo.txmap.model.Location;
import com.demo.txmap.model.TencentMapDTO;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.math.BigDecimal;
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
        dto.setUdId("1266814988");
        dto.setLocation(new Location(new BigDecimal("30.546120"),new BigDecimal("104.066464")));
        dto.setTitle("新希望B座");
        dto.setX(new LeaderMapDTO("1栋一单元1","11","张无忌"));
        list.add(dto);
        Object o = cloudMapService.saveData("5f3e81a0f969d52d3f259197", list);
    }

    @Test
    void testGeoCoder() throws IOException {
        Object o = cloudMapService.geoCoder(new BigDecimal("30.546120"), new BigDecimal("104.066464"));


    }
}
