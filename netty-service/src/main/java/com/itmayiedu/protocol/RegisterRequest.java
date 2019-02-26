package com.itmayiedu.protocol;


import com.itmayiedu.base.BaseMsg;
import com.itmayiedu.base.MsgType;
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