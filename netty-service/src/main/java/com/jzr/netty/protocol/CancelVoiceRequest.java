package com.jzr.netty.protocol;

import com.jzr.netty.base.BaseMsg;
import com.jzr.netty.base.MsgType;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter

public class CancelVoiceRequest extends BaseMsg {

    private String CancelIp;
    private  String bedInfo;
    public CancelVoiceRequest() {
        super();
        setType(MsgType.CANCEL_VOICE);
    }
}