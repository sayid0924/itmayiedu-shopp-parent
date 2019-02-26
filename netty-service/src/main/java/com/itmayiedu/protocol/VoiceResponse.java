package com.itmayiedu.protocol;
import com.itmayiedu.base.BaseMsg;
import com.itmayiedu.base.MsgType;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class VoiceResponse extends BaseMsg {
    private Integer status;
    private String bedInfo;


    public VoiceResponse() {
        super();
        setType(MsgType.VOICE);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}