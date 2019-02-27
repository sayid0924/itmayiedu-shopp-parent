package com.jzr.netty.protocol;


import com.jzr.netty.base.BaseMsg;
import com.jzr.netty.base.MsgType;

/**
 * @author 陈旭东
 * @version 1.0
 * @date 2018年11月10日
 */
public class RegisterResponse extends BaseMsg {


    public RegisterResponse() {
        super();
        setType(MsgType.REGISTER);
    }

}