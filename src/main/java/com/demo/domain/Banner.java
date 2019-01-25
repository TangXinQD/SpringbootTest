package com.demo.domain;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-12-20
 */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDirectUrl() {
        return directUrl;
    }

    public void setDirectUrl(String directUrl) {
        this.directUrl = directUrl == null ? null : directUrl.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }

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