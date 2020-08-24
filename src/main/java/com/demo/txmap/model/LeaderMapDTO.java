package com.demo.txmap.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TX
 * @version 1.0
 * @description LeaderMapDTO
 * @date 2020/8/24 11:18 上午
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LeaderMapDTO {

    private String address;

    @JSONField(name = "citycode" )
    private String cityCode;

//    @JSONField(name = "headimg" )
//    private String headImg;

    private String name;

}
