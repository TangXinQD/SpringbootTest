package com.demo.demo.kyTest;

import lombok.Data;

import java.util.Date;

public class ReceiveNotifyWaitHandle {
    /**
     * 状态
     */
    private String status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 通知类型
     */
    private String notifyType;

    /**
     * 签名
     */
    private String sign;

    /**
     * 时间戳
     */
    private String timeStamp;

    /**
     * 接收的KEY
     */
    private String acceptKey;

    /**
     * 流水号
     */
    private String flowNo;

    /**
     * 接入标志
     */
    private String dockingFlag;

    /**
     * 内容
     */
    private String content;

    /**
     * 处理次数
     */
    private Integer handleCount=0;

    /**
     * 当前执行的开始时间
     */
    private Date curRetryTime;

    /**
     * 下次重试执行开始时间
     */
    private Date nextRetryTime;

    /**
     * 类名
     */
    private String className;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 接收标志：Y接收,N发送
     */
    private String receiveFlag;

    /**
     * 备注
     */
    private String remark;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getAcceptKey() {
        return acceptKey;
    }

    public void setAcceptKey(String acceptKey) {
        this.acceptKey = acceptKey;
    }

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo;
    }

    public String getDockingFlag() {
        return dockingFlag;
    }

    public void setDockingFlag(String dockingFlag) {
        this.dockingFlag = dockingFlag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getHandleCount() {
        return handleCount;
    }

    public void setHandleCount(Integer handleCount) {
        this.handleCount = handleCount;
    }

    public Date getCurRetryTime() {
        return curRetryTime;
    }

    public void setCurRetryTime(Date curRetryTime) {
        this.curRetryTime = curRetryTime;
    }

    public Date getNextRetryTime() {
        return nextRetryTime;
    }

    public void setNextRetryTime(Date nextRetryTime) {
        this.nextRetryTime = nextRetryTime;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getReceiveFlag() {
        return receiveFlag;
    }

    public void setReceiveFlag(String receiveFlag) {
        this.receiveFlag = receiveFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
