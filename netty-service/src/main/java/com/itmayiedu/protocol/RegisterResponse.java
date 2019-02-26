package com.itmayiedu.protocol;


import com.itmayiedu.base.BaseMsg;
import com.itmayiedu.base.MsgType;

/**
 * @author 陈旭东
 * @version 1.0
 * @date 2018年11月10日
 */
public class RegisterResponse extends BaseMsg {
    private Integer status;

    public RegisterResponse() {
        super();
        setType(MsgType.REGISTER);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}