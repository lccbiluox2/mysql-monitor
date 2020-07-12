package com.neo.service.impl;

import com.neo.dao.DatabaseDao;
import com.neo.entity.dao.DataBaseDao;
import com.neo.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseServiceImpl implements DatabaseService {

    @Autowired
    private DatabaseDao databaseDao;

    @Override
    public void insert(DataBaseDao dataBaseDao) {
        databaseDao.insert(dataBaseDao);
    }

    @Override
    public List<DataBaseDao> listAll() {
        return databaseDao.listAll();
    }

    @Override
    public void deleteById(int id) {
        databaseDao.deleteById(id);
    }

    @Override
    public DataBaseDao selectById(int id) {
        return databaseDao.selectById(id);
    }
}
