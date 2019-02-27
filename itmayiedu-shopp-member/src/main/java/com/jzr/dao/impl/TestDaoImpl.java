package com.jzr.dao.impl;

import com.jzr.dao.TestDao;
import com.jzr.mybatis.mapper.MbTestMapper;
import com.jzr.mybatis.model.MbTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class TestDaoImpl  implements TestDao {

    @Autowired
    private MbTestMapper mbtestMapper;

    public MbTest insertUser(MbTest user) {
        if (mbtestMapper.insert(user) > 0) {
            return user;
        }
        return null;
    }

}
