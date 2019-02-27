package com.jzr.netty.protocol;

import com.jzr.netty.base.BaseMsg;
import com.jzr.netty.base.MsgType;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class VoiceResponse extends BaseMsg {

    private String bedInfo;


    public VoiceResponse() {
        super();
        setType(MsgType.VOICE);
    }

}