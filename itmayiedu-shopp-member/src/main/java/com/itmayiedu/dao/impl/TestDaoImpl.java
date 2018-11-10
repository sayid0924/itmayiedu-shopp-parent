package com.itmayiedu.dao.impl;

import com.itmayiedu.dao.TestDao;
import com.itmayiedu.mybatis.mapper.MbtestMapper;
import com.itmayiedu.mybatis.model.Mbtest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class TestDaoImpl  implements TestDao {

    @Autowired
    private MbtestMapper mbtestMapper;

    public Mbtest insertUser(Mbtest user) {
        if (mbtestMapper.insert(user) > 0) {
            return user;
        }
        return null;
    }

}
