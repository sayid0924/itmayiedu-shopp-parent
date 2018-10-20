package com.itmayiedu.dao;


import com.github.pagehelper.Page;
import com.itmayiedu.entity.RoleManage.RoleEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleManageDao {


    @Select("select id,RoleAttributes,RoleDescribe,RoleType,RoleName,RoleDisable,RoleLeve " +
            "from mb_role where id =#{RoleId}")
    RoleEntity findByID(@Param("RoleId") Long RoleId);

    @Select("select id,RoleAttributes,RoleDescribe,RoleType,RoleName,RoleDisable,RoleLeve from mb_role ")
    Page<RoleEntity> findAll();

    @Insert("INSERT  INTO `mb_role`  (RoleAttributes,RoleDescribe,RoleType,RoleName)  VALUES (#{RoleAttributes}, #{RoleDescribe},#{RoleType},#{RoleName});")
    Integer insertUser(RoleEntity roleAdd);


    @Delete("delete from mb_role where id=#{RoleId}")
    Integer delete(Long RoleId);


    @Select("update mb_role set RoleDisable=1  where id=#{RoleId}")
    Integer roleDisable(@Param("RoleId") Long RoleId);

}
