package com.jzr.netty.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public abstract class BaseMsg implements Serializable {
    private static final long serialVersionUID = 1L;
    private MsgType type;
    //必须唯一，否者会出现channel调用混乱
    private String clientId;
    private  String ip;
    private String equipmentType;  //设备类型 1=床头卡，2=移动护理PDA，3=门旁系统

}