package com.demo.txmap;

import com.demo.txmap.model.TencentMapDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author TX
 * @version 1.0
 * @description CloudMapService
 * @date 2020/8/24 11:22 上午
 */
public interface CloudMapService {
    Object saveData(String table, List<TencentMapDTO> list) throws JsonProcessingException;

    Object geoCoder(BigDecimal lat,BigDecimal lng) throws JsonProcessingException;
}
