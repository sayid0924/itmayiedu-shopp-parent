package com.itmayiedu.protocol;


import com.itmayiedu.base.BaseMsg;
import com.itmayiedu.base.MsgType;

public class LockScreenRequest extends BaseMsg {

    public LockScreenRequest() {
        super();
        setType(MsgType.LOCK_SCREEN);
    }
}