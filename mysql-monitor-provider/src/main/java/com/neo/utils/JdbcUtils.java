package com.neo.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcUtils {

    /**
     * 查询某个变量
     *
     * @param connect
     * @param name
     * @param sql
     */
    public static String getVariable(Connection connect, String name, String sql) {
        try {
            Statement st = connect.createStatement();
            System.out.println(connect.getCatalog());
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                return result.getString(name);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Map<String, String> getALlVariable(Connection connect) {
        Map<String, String> map = new HashMap<>();
        try {
            Statement st = connect.createStatement();
            System.out.println(connect.getCatalog());
            ResultSet result = st.executeQuery("show variables");
            while (result.next()) {
                String name = result.getString(1);
                String value = result.getString(2);
                map.put(name, value);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Map<String, String> getVariables(Connection connect, String sql) {
        Map<String, String> map = new HashMap<>();
        try {
            Statement st = connect.createStatement();
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                String name = result.getString(1);
                String value = result.getString(2);
                map.put(name, value);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Map<String, String> getDbSize(Connection connect, String database) {
        String sql = "SELECT table_schema, concat(truncate(sum(max_data_length)/1024/1024,2),'mb') as max_data_size,  sum( data_length + index_length ) / 1024 / 1024 AS total_mb,sum( data_length ) / 1024 / 1024 AS data_mb,concat(truncate(sum(data_free)/1024/1024,2),'mb') as data_free, sum( index_length ) / 1024 / 1024 AS index_mb,count( * ) AS TABLES,curdate( ) AS today  FROM information_schema.TABLES where table_schema = '" + database + "' GROUP BY table_schema ORDER BY 2 DESC ;";
        Map<String, String> map = new HashMap<>();
        try {
            Statement st = connect.createStatement();
            ResultSet result = st.executeQuery(sql);
            ResultSetMetaData meta = result.getMetaData();
            int count = meta.getColumnCount();
            for (int i = 1; i <= count; i++) {
                if(i==1){
                    result.next();
                }
                String name = meta.getColumnName(i);
                String value = result.getString(name);
                map.put(name, value);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
}
