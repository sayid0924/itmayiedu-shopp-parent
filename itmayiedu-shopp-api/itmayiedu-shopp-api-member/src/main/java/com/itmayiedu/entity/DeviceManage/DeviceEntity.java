package com.itmayiedu.entity.DeviceManage;

import com.apidoc.annotation.ApiParam;
import com.apidoc.enumeration.DataType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class DeviceEntity {

    private  Integer  id;
    private  String deviceNo;
    private  String deviceIp;
    private  String deviceClass;
    private  String deviceArea;
    private  String deviceLocation;
    private  String deviceStart;



}
