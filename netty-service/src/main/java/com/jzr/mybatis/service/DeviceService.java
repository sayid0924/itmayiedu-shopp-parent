package com.jzr.mybatis.service;

import com.jzr.mybatis.model.Device;

import java.util.List;

public interface DeviceService {


    /**
     * 查询所有設備
     * @return
     */
    List<Device> findAll();

    /**
     * 根据主键查询設備
     * @param bedId
     * @return
     */
    Device selectByPrimaryKey(Integer bedId);


    Device selectByPrimaryIp(String ip);

    /**
     * 新增設備信息
     * @param record
     * @return
     */
    Device insertSelective(Device record);

    /**
     * 更新設備信息
     * @param record
     * @return
     */
    Device updateByPrimarykey(Device record);

    /**
     * 删除設備信息
     * @param bedId
     * @return
     */
    int deleteByPrimarykey(Integer bedId);

    /**
     *  根据讲条件查询設備信息
     * @param record
     * @return
     */
    List<Device> selectByCondition(Device record);

}
