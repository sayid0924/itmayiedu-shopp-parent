package com.jzr.netty.utils;

import com.jzr.mybatis.model.Device;
import com.jzr.mybatis.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class TestUtils {

    @Autowired
    private DeviceService deviceService;

//    @Autowired
//    private DeviceMapper deviceMapper;

    public static TestUtils testUtils;

    @PostConstruct
    public void init() {
        testUtils = this;
    }

    public static void insertSelective(Device device ) {
        testUtils.deviceService.insertSelective(device);

    }

    public static void updateByPrimarykey(Device device) {
        testUtils.testUtils.deviceService.updateByPrimarykey(device);

    }

    public static Device selectByPrimaryIp(String ip) {
        Device devices = testUtils.testUtils.deviceService.selectByPrimaryIp(ip);
        return devices;
    }
}