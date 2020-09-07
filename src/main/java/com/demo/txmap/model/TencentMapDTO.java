package com.demo.txmap.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @author TX
 * @version 1.0
 * @description 腾讯云图存储DTO
 * @date 2020/8/24 11:07 上午
 */
@Data
public class TencentMapDTO {

    @JSONField(name = "ud_id")
    private String udId;

    /**
     * 地点名称
     */
    private String title;

    /**
     * 地址
     */
    private String address;

    private Location location;

    private Object x;
}
