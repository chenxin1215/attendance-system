package com.attendance.dto.view;

/**
 * 功能描述: 返回参数模板
 *
 * @Author: xx
 * @Date: 2019/12/9
 */
public class BaseView<T> {

    /**
     * 成功, 对应前端会回调
     */
    public static final String SUCCESS = "1";

    /**
     * 失败, 对应前端会提示错误
     */
    public static final String NOTIFY = "-1";

    /**
     * 失败通知, 不会提示错误
     */
    public static final String SILENCE = "0";

    /** 状态码. */
    private String rspCode;

    /** 返回信息. */
    private String rspMsg;

    /** 返回数据. */
    private T rspData;

    public String getRspCode() {
        return rspCode;
    }

    public void setRspCode(String rspCode) {
        this.rspCode = rspCode;
    }

    public String getRspMsg() {
        return rspMsg;
    }

    public void setRspMsg(String rspMsg) {
        this.rspMsg = rspMsg;
    }

    public T getRspData() {
        return rspData;
    }

    public void setRspData(T rspData) {
        this.rspData = rspData;
    }

    /** 设置默认成功消息 */
    public void success() {
        this.setRspCode(SUCCESS);
        this.setRspMsg("查询成功");
    }

    /** 设置返回状态为成功，自定义返回消息 */
    public void success(T rspData) {
        this.setRspCode(SUCCESS);
        this.setRspMsg("查询成功");
        this.setRspData(rspData);
    }

    public void success(String rspMsg, T rspData) {
        this.setRspCode(SUCCESS);
        this.setRspMsg(rspMsg);
        this.setRspData(rspData);
    }

    public void success(String rspCode, String rspMsg, T rspData) {
        this.setRspCode(rspCode);
        this.setRspMsg(rspMsg);
        this.setRspData(rspData);
    }

}
