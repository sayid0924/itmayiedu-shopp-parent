package com.jzr.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class Device implements Serializable {
    private Integer id;

    private String deviceNo;

    private String deviceMac;

    private String deviceIp;

    private String deviceType;

    private String registerBed;

    private Integer registerState;

    private String appVersion;

    private String nurseboardIp;

    private Date lastUpTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getRegisterBed() {
        return registerBed;
    }

    public void setRegisterBed(String registerBed) {
        this.registerBed = registerBed;
    }

    public Integer getRegisterState() {
        return registerState;
    }

    public void setRegisterState(Integer registerState) {
        this.registerState = registerState;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getNurseboardIp() {
        return nurseboardIp;
    }

    public void setNurseboardIp(String nurseboardIp) {
        this.nurseboardIp = nurseboardIp;
    }

    public Date getLastUpTime() {
        return lastUpTime;
    }

    public void setLastUpTime(Date lastUpTime) {
        this.lastUpTime = lastUpTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deviceNo=").append(deviceNo);
        sb.append(", deviceMac=").append(deviceMac);
        sb.append(", deviceIp=").append(deviceIp);
        sb.append(", deviceType=").append(deviceType);
        sb.append(", registerBed=").append(registerBed);
        sb.append(", registerState=").append(registerState);
        sb.append(", appVersion=").append(appVersion);
        sb.append(", nurseboardIp=").append(nurseboardIp);
        sb.append(", lastUpTime=").append(lastUpTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}