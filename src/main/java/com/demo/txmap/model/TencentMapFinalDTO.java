package com.demo.txmap.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author TX
 * @version 1.0
 * @description 腾讯云图存储DTO
 * @date 2020/8/24 11:07 上午
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TencentMapFinalDTO {

   private String key;

   private String table_id;

   private List<TencentMapDTO> data;
}
