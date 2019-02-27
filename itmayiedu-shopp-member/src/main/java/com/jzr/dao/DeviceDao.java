package com.jzr.dao;

import com.github.pagehelper.Page;
import com.jzr.entity.DeviceManage.DeviceEntity;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DeviceDao {


    @Insert("INSERT  INTO `mb_device`  (deviceNo,deviceIp,deviceClass,deviceArea,deviceLocation,deviceStart) " +
            "VALUES (#{deviceNo}, #{deviceIp},#{deviceClass},#{deviceArea},#{deviceLocation},#{deviceStart});")
    Integer insertUser(DeviceEntity deviceEntity);

    @Select("select  id,deviceNo,deviceIp,deviceClass,deviceArea,deviceLocation,deviceStart from mb_device where id =#{deviceId}")
    DeviceEntity   findByID(@Param("deviceId") Long deviceId);

    @Delete("delete from mb_device where id=#{deviceId}")
    Integer dcviceDelete(@Param("deviceId") Long deviceId);

    @Select("update mb_device set deviceNo=#{deviceNo} deviceIp=#{deviceIp} deviceClass=#{deviceClass} deviceArea=#{deviceArea} deviceLocation=#{deviceLocation} deviceStart=#{deviceStart}    where id=#{deviceId}")
    Integer dcviceUpdate(DeviceEntity deviceEntity);

    @Select("select id,deviceNo,deviceIp,deviceClass,deviceArea,deviceLocation,deviceStart from mb_device")
    Page<DeviceEntity> findAll();

}
