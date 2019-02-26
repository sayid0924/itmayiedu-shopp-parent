package com.itmayiedu.protocol;


import com.itmayiedu.base.BaseMsg;
import com.itmayiedu.base.MsgType;

public class CancelVideoRequest extends BaseMsg {
    public CancelVideoRequest() {
        super();
        setType(MsgType.CANCEL_VIDEO);
    }
}