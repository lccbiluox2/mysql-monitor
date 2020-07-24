package com.neo.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.neo.entity.ConnectMessage;
import com.neo.entity.dao.DataBaseDao;
import com.neo.entity.response.DatabaseAddRes;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class JdbcSessionPlugin {

    private static final int CONNECT_POOL_SIZE = 1;

    private static final int CONNECT_POOL_MAX_SIZE = 5;

    /**
     * 设置5s连接超时
     */
    private static final int CONNECTION_TIMEOUT = 15000;

    /**
     * 2分钟未使用转为空闲状态
     */
    private static final int IDLE_TIMEOUT = 2 * 60 * 1000;

    Cache<String, Connection> cache = null;


    public JdbcSessionPlugin() {
        super();
        cache = CacheBuilder.newBuilder().maximumSize(1000)
                .expireAfterAccess(Integer.MAX_VALUE, TimeUnit.SECONDS)
                .concurrencyLevel(10)
                .recordStats()
                .build();
    }


    private HikariConfig getHikariConfig(ConnectMessage connectMessage) {
        HikariConfig hikariConfig = new HikariConfig();

        // 这里可以动态
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl(connectMessage.getConnectUrl());
        hikariConfig.setUsername(connectMessage.getUserName());
        hikariConfig.setPassword(connectMessage.getPassword());
        hikariConfig.setMaximumPoolSize(CONNECT_POOL_MAX_SIZE);
        hikariConfig.setMinimumIdle(CONNECT_POOL_SIZE);
        hikariConfig.setConnectionTimeout(CONNECTION_TIMEOUT);
        hikariConfig.setIdleTimeout(IDLE_TIMEOUT);

        return hikariConfig;
    }


    protected Connection getConnection(ConnectMessage connectMessage) {
        Connection conn = null;
        try {
            HikariDataSource dataSource = new HikariDataSource(getHikariConfig(connectMessage));
            conn = dataSource.getConnection();
            cache.put(connectMessage.getName(), conn);
        } catch (Exception e) {
            log.info("连接异常:{}",connectMessage);
        }
        return conn;
    }


    /**
     * 获取数据库的状态
     *
     * @param list
     * @return
     */
    public List<DatabaseAddRes> getDatabaseStatus(List<DataBaseDao> list) {

        List<DatabaseAddRes> listRes = new ArrayList<>();
        for (DataBaseDao dataBaseDao : list) {

            DatabaseAddRes databaseAddRes = new DatabaseAddRes();
            BeanUtils.copyProperties(dataBaseDao, databaseAddRes);

            String ip = dataBaseDao.getIp();
            Integer port = dataBaseDao.getPort();
            boolean connected = PingUtils.isHostConnectable(ip, port);
            if(!connected){
                databaseAddRes.setStatus("false");
                listRes.add(databaseAddRes);
                continue;
            }

            String url = "jdbc:mysql://host:port/database?useUnicode=true&characterEncoding=utf-8&useSSL=true";
            String name = dataBaseDao.getName();
            url = url.replace("host", dataBaseDao.getIp());
            url = url.replace("port", dataBaseDao.getPort() + "");
            url = url.replace("database", dataBaseDao.getDatabase());

            ConnectMessage connectMessage = new ConnectMessage();
            connectMessage.setConnectUrl(url);
            connectMessage.setUserName(dataBaseDao.getUsername());
            connectMessage.setPassword(dataBaseDao.getPassword());
            connectMessage.setName(name);



            @Nullable Connection connect = cache.getIfPresent(name);
            if (connect == null) {
                connect = getConnection(connectMessage);
            }
            if (connect == null) {
                databaseAddRes.setStatus("false");
                listRes.add(databaseAddRes);
                continue;
            }
            boolean flag = false;
            try {
                flag = ((Connection) connect).isValid(6000);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // 设置连接是否成功
            if (flag) {
                databaseAddRes.setStatus("true");
            } else {
                databaseAddRes.setStatus("false");
            }
            listRes.add(databaseAddRes);
        }

        return listRes;
    }

    public Connection getConnect(DataBaseDao dataBaseDao) {
        String name = dataBaseDao.getName();

        String url = "jdbc:mysql://host:port/database?useUnicode=true&characterEncoding=utf-8&useSSL=true";
        url = url.replace("host", dataBaseDao.getIp());
        url = url.replace("port", dataBaseDao.getPort() + "");
        url = url.replace("database", dataBaseDao.getDatabase());

        ConnectMessage connectMessage = new ConnectMessage();
        connectMessage.setConnectUrl(url);
        connectMessage.setUserName(dataBaseDao.getUsername());
        connectMessage.setPassword(dataBaseDao.getPassword());
        connectMessage.setName(name);


        Connection connect = null;
        try {
            connect = cache.get(name, new Callable<Connection>() {
                @Override
                public Connection call() throws Exception {
                    return getConnection(connectMessage);
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return connect;


    }
}
