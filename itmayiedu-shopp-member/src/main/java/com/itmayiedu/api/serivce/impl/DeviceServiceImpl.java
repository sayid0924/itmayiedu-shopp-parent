package com.itmayiedu.api.serivce.impl;

import com.itmayiedu.api.service.DeviceService;
import com.itmayiedu.base.BaseApiService;
import com.itmayiedu.base.ResponseBase;
import com.itmayiedu.dao.DeviceDao;
import com.itmayiedu.entity.DeviceManage.DeviceEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;



@Slf4j
@RestController
public class DeviceServiceImpl extends BaseApiService implements DeviceService {

//    @Autowired
//    private DeviceDao deviceDao;

    @Override
    @HystrixCommand(fallbackMethod="hystrixFallback")
    public ResponseBase DeviceAdd(DeviceEntity deviceEntity) {
//        if (StringUtils.isEmpty(deviceEntity.getDeviceNo())) {
//            return setResultError("设备号不能为空!");
//        }
//        Integer result =  deviceDao.insertUser(deviceEntity);
//
//        if (result <= 0) {
//            return setResultError("添加失败.");
//        }
        return setResultSuccess("添加成功");

    }

    @Override
    @HystrixCommand(fallbackMethod="hystrixFallback")
    public ResponseBase DeviceDelete(Long deviceId) {

//        if (deviceId==null ) {
//            return setResultError("设备ID不能为空!");
//        }
//        Integer result =  deviceDao.dcviceDelete(deviceId);
//
//        if (result <= 0) {
//            return setResultError("删除失败.");
//        }
        return setResultSuccess("删除成功");

    }

    @Override
    @HystrixCommand(fallbackMethod="hystrixFallback")
    public ResponseBase DeviceFind(Long deviceId) {
//        if (deviceId==null ) {
//            return setResultError("设备ID不能为空!");
//        }
//        DeviceEntity result =  deviceDao.findByID(deviceId);
//
//        if (result  ==null) {
//            return setResultError("未查找到设备信息.");
//        }
        return setResultSuccess("未查找到设备信息.");
    }

    @Override
    @HystrixCommand(fallbackMethod="hystrixFallback")
    public ResponseBase DeviceUpdate(DeviceEntity deviceEntity) {
//        if (deviceEntity.getId()==null ) {
//            return setResultError("设备ID不能为空!");
//        }
//        if (deviceEntity.getDeviceNo()==null ) {
//            return setResultError("设备号不能为空!");
//        }
//        Integer result =  deviceDao.dcviceUpdate(deviceEntity);
//        if (result <= 0) {
//            return setResultError("更新失败.");
//        }
        return setResultSuccess("更新成功");
    }

    public ResponseBase hystrixFallback() {
        return setResultError("请求失败");
    }

//    /**
//     *  分页查找角色
//     * @return
//     */
//    @Override
//    public ResponseBase RolemanageFindAll( Integer pageNo, Integer pageSize) {
//        PageHelper.startPage(pageNo, pageSize);
//        Page<RoleEntity> role = roleManageDao.findAll();
//        if (role == null) {
//            return setResultError("未查找到角色信息.");
//        }
//        return setResultSuccess(role);
//    }

}
