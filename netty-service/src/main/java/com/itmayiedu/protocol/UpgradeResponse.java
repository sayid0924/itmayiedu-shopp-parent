package com.itmayiedu.protocol;


import com.itmayiedu.base.BaseMsg;
import com.itmayiedu.base.MsgType;

/**
 * @author 陈旭东
 * @version 1.0
 * @date 2018年11月10日
 */
public class UpgradeResponse extends BaseMsg {
    private Integer status;
    private String appPath;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    private Integer version;

    public UpgradeResponse() {
        super();
        setType(MsgType.UPGRADE);
    }

    public String getAppPath() {
        return appPath;
    }

    public void setAppPath(String appPath) {
        this.appPath = appPath;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
