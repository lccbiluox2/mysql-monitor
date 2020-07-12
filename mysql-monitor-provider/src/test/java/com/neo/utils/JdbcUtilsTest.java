package com.neo.utils;

import com.neo.BaseTest;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.*;
import com.mysql.cj.jdbc.Driver;

public class JdbcUtilsTest extends BaseTest {


    //这个工具类,主要为我们获取一个数据库连接
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/mysql_monitor?useUnicode=true&characterEncoding=utf-8&useSSL=true\n";
    private static String username = "root";
    private static String password = "12345678";

    Connection conn = null;

    @Before
    public void getConnection() throws Exception {
        //1.加载驱动
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            //System.out.println("驱动加载失败..请检查驱动包");
            throw new RuntimeException("驱动加载失败..请检查驱动包");
        }

        //2.获取和数据库的连接
        conn = DriverManager.getConnection(url, username, password);
    }

    @Test
    public void getStatus() {
//        JdbcUtils.getStatus(conn);
    }
}