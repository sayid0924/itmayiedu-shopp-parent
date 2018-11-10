package com.itmayiedu.mybatis.mapper;

import com.itmayiedu.mybatis.model.MbTest;
import com.itmayiedu.mybatis.model.MbTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MbTestMapper {
    int countByExample(MbTestExample example);

    int deleteByExample(MbTestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MbTest record);

    int insertSelective(MbTest record);

    List<MbTest> selectByExample(MbTestExample example);

    MbTest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MbTest record, @Param("example") MbTestExample example);

    int updateByExample(@Param("record") MbTest record, @Param("example") MbTestExample example);

    int updateByPrimaryKeySelective(MbTest record);

    int updateByPrimaryKey(MbTest record);
}