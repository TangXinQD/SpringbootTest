package com.demo.domain;

import lombok.Data;

import java.util.Date;

/**
 * 系统日志表
 * 
 * @author TX
 * 
 * @date 2019-01-25
 */
@Data
public class Log {
    private Long id;

    /**
     * 操作人
     */
    private String createBy;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 类型 :0-前置通知；1-异常通知
     */
    private Byte type;

    /**
     * 日志内容
     */
    private String description;

    /**
     * 用户ip
     */
    private String requestIp;

    private String method;

    private String exceptionCode;

    private String exceptionDetail;

    /**
     * 请求参数
     */
    private String args;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp == null ? null : requestIp.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode == null ? null : exceptionCode.trim();
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }

    public void setExceptionDetail(String exceptionDetail) {
        this.exceptionDetail = exceptionDetail == null ? null : exceptionDetail.trim();
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args == null ? null : args.trim();
    }
}