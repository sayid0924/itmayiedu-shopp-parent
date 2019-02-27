package com.jzr.netty.protocol;


import com.jzr.netty.base.BaseMsg;
import com.jzr.netty.base.MsgType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoiceRequest extends BaseMsg {
    private Object voice;
    private String nurseCeardIp;
    private  String bedInfo;

    public VoiceRequest() {
        super();
        setType(MsgType.VOICE);
    }

}