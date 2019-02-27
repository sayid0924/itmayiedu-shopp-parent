package com.jzr.entity.RommCardManage;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoomCardEntity {

//    roomName roomInfo roomDeviceIp roomDeviceMac roomDoctor roomNurse roomLocation roomDescribe

    private  Integer id;
    private  String roomName;
    private  String roomInfo;
    private  String roomDeviceIp;
    private  String roomDeviceMac;
    private  String roomDoctor;
    private  String roomNurse;
    private  String roomLocation;
    private  String roomDescribe;

}
