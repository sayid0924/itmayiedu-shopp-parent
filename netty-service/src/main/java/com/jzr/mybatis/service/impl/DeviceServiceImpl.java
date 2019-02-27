package com.jzr.mybatis.service.impl;

import com.jzr.mybatis.mapper.DeviceMapper;
import com.jzr.mybatis.model.Device;
import com.jzr.mybatis.model.DeviceExample;
import com.jzr.mybatis.service.DeviceService;
import com.jzr.utils.A;
import com.jzr.utils.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "DeviceService")
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public List<Device> findAll() {
        List<Device> tBedList = deviceMapper.selectByExample(null);
        if (tBedList != null && tBedList.size() != 0)
            return tBedList;
        else
            return null;
    }

    @Override
    public Device selectByPrimaryKey(Integer bedId) {
        return null;
    }

    @Override
    public Device selectByPrimaryIp(String ip) {
        if (ip==null){
            return null;
        }
        DeviceExample tDeviceExample = new DeviceExample();
        DeviceExample.Criteria criteria = tDeviceExample.createCriteria();
        criteria.andDeviceIpEqualTo(ip);
        List<Device> tDeptList = deviceMapper.selectByExample(tDeviceExample);
        if(tDeptList!=null && tDeptList.size()!=0){
            return  tDeptList.get(0);
        }else {
            return null;
        }
    }

    @Override
    public Device insertSelective(Device device) {
        if (device==null){
            return null;
        }
        int count = deviceMapper.insertSelective(device);
        if (0 == count){
            return null;
        }
        return  null;
    }

    @Override
    public Device updateByPrimarykey(Device record) {
        Device tDevice = selectByIp(record.getDeviceIp());
        if (U.isBlank(tDevice)){
            return null;
        }
        record.setId(tDevice.getId());
        int count = deviceMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public int deleteByPrimarykey(Integer bedId) {
        return 0;
    }

    @Override
    public List<Device> selectByCondition(Device record) {
        return null;
    }

    private Device selectByIp(String ip){
        if (U.isBlank(ip)){
            return null;
        }
        DeviceExample tDeviceExample = new DeviceExample();
        DeviceExample.Criteria criteria = tDeviceExample.createCriteria();
        criteria.andDeviceIpEqualTo(ip);
        List<Device> tDeptList = deviceMapper.selectByExample(tDeviceExample);
        if (A.isEmpty(tDeptList)){
            return null;
        }
        return A.first(tDeptList);
    }

}
