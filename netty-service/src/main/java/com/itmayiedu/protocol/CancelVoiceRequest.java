package com.itmayiedu.protocol;


import com.itmayiedu.base.BaseMsg;
import com.itmayiedu.base.MsgType;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter

public class CancelVoiceRequest extends BaseMsg {

    private String nurseCeardIp;
    private  String bedInfo;
    public CancelVoiceRequest() {
        super();
        setType(MsgType.CANCEL_VOICE);
    }
}