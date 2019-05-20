package com.demo.domain;

import lombok.Data;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-12-20
 */
@Data
public class Banner {
    private Integer id;

    private String directUrl;

    /**
     * 标题
     */
    private String title;

    private String imageUrl;

    /**
     * 限制类型：0:主页，1酒店、2景区、3线路
     */
    private Integer typeId;

    /**
     * 领用开始日期
     */
    private Date createTime;

    private String createUserId;

    private Integer sort;

    private Boolean display;

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", directUrl='" + directUrl + '\'' +
                ", title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", typeId=" + typeId +
                ", createTime=" + createTime +
                ", createUserId='" + createUserId + '\'' +
                ", sort=" + sort +
                ", display=" + display +
                '}';
    }
}