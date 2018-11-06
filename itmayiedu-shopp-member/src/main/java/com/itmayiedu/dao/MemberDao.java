package com.itmayiedu.dao;

import com.github.pagehelper.Page;
import com.itmayiedu.entity.RoleManage.RoleEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.itmayiedu.entity.UserEntity;

@Mapper
public interface MemberDao {

	@Select("select  id,username,password,phone,email,created,updated from mb_user where id =#{userId}")
	UserEntity findByID(@Param("userId") Long userId);

	@Insert("INSERT  INTO `mb_user`  (username,password,phone,email,created,updated) VALUES (#{username}, #{password},#{phone},#{email},#{created},#{updated});")
	Integer insertUser(UserEntity userEntity);

	@Select("select  id,username,password,phone,email,created,updated from mb_user where username=#{username} and password=#{password}")
	UserEntity login(@Param("username") String username, @Param("password") String password);

	@Select("update mb_user set password=#{password}  where id=#{userId}")
	UserEntity changePassword(@Param("userId") Long userId,@Param("password") String password );


	@Select("select id,username,password,phone,email,created,updated from mb_user ")
	Page<UserEntity> findAll();

}
