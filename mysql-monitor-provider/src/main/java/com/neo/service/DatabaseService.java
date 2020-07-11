package com.neo.service;

import com.neo.entity.dao.DataBaseDao;

import java.util.List;

public interface DatabaseService {
    /**
     * 插入数据
     * @param dataBaseDao
     */
    void insert(DataBaseDao dataBaseDao);

    /**
     * 查询所有的数据库
     * @return
     */
    List<DataBaseDao> listAll();

    void deleteById(int id);
}
