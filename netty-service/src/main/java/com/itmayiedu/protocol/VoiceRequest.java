package com.itmayiedu.protocol;

import com.itmayiedu.base.BaseMsg;
import com.itmayiedu.base.MsgType;
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