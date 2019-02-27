package com.jzr.netty.protocol;

import com.jzr.netty.base.BaseMsg;
import com.jzr.netty.base.MsgType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class RegisterRequest extends BaseMsg {

    public RegisterRequest() {
        super();
        setType(MsgType.REGISTER);
    }

}