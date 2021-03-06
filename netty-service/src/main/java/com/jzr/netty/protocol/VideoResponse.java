package com.jzr.netty.protocol;


import com.jzr.netty.base.BaseMsg;
import com.jzr.netty.base.MsgType;

public class VideoResponse extends BaseMsg {
    private Integer status;

    public VideoResponse() {
        super();
        setType(MsgType.VIDEO);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}