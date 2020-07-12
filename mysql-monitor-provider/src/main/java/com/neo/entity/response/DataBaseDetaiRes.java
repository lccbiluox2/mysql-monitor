package com.neo.entity.response;

import com.neo.entity.dao.DataBaseDao;
import lombok.Data;

import java.util.Map;

@Data
public class DataBaseDetaiRes extends DataBaseDao {

    private String version;
    /**
     * MYSQL 安装目录
     */
    private String mySqlHome;

    private String basedir;
    /**
     * MySQL 数据存放的位置
     */
    private String datadir;


    /**
     * 数据库 大小简介
     */
    private Map<String, String> dbSize;

    /**
     * 数据库编码信息
     */
    private Map<String, String> charMap;
    /**
     * 错误日志
     */
    private Map<String, String> logError;

    /**
     * 二进制日志
     */
    private Map<String, String> logBin;
    /**
     * 通用日志
     */
    private Map<String, String> generalLog;
    /**
     * 慢查询日志
     */
    private Map<String, String> slowQueryLog;
    /**
     * 最大连接数
     */
    private Map<String, String> maxConnecttion;
    /**
     * 线程数
     */
    private Map<String, String> threads;

    /**
     * table lock
     */
    private Map<String, String> tableLock;



    private Map<String, String> variables;
}
