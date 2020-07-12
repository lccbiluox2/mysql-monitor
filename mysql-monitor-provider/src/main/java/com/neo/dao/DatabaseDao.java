package com.neo.dao;

import com.neo.entity.dao.DataBaseDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatabaseDao {
    /**
     * 插入
     * @param dataBaseDao
     */
    void insert(DataBaseDao dataBaseDao);

    List<DataBaseDao> listAll();

    void deleteById(@Param("id") int id);

    DataBaseDao selectById(@Param("id") int id);
}
