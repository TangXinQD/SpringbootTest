package com.demo.txmap.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author TX
 * @version 1.0
 * @description Location
 * @date 2020/8/24 11:15 上午
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Location {

    /**
     * 纬度
     */
    private BigDecimal lat;

    /**
     * 精度
     */
    private BigDecimal lng;
}
