package com.demo.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * gp-省市区表
 * </p>
 *
 * @author TX
 * @since 2020-08-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("gp_location")
public class GpLocationVO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 编码
     */
    private String code;

    /**
     * 姓名
     */
    private String name;

    /**
     * 父编码
     */
    private String parentCode;

    /**
     * 顺序
     */
    private Integer sequence;

    /**
     * 区域类型（1国家2省3市4区5街道）
     */
    private Integer type;

    private String pinyinName;

    private String header;

}
