package com.jzr.netty.protocol;


import com.jzr.netty.base.BaseMsg;
import com.jzr.netty.base.MsgType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PingMsg extends BaseMsg {

    private  String MacIp;
    private  String AppVersion;
    private  String NurseboardIp;

    public PingMsg() {
        super();
        setType(MsgType.PING);
    }
}