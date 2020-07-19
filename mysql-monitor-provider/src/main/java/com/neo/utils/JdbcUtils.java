package com.neo.utils;

import com.neo.entity.dao.TableColumns;
import com.neo.entity.dao.TableIndex;
import com.neo.entity.response.TableDesc;

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

    /**
     * 获取数据库的大小
     *
     * @param connect
     * @param database
     * @return
     */
    public static Map<String, String> getDbSize(Connection connect, String database) {
        String sql = "SELECT table_schema, concat(truncate(sum(max_data_length)/1024/1024,2),'mb') as max_data_size,  sum( data_length + index_length ) / 1024 / 1024 AS total_mb,sum( data_length ) / 1024 / 1024 AS data_mb,concat(truncate(sum(data_free)/1024/1024,2),'mb') as data_free, sum( index_length ) / 1024 / 1024 AS index_mb,count( * ) AS TABLES,curdate( ) AS today  FROM information_schema.TABLES where table_schema = '" + database + "' GROUP BY table_schema ORDER BY 2 DESC ;";
        Map<String, String> map = new HashMap<>();
        try {
            Statement st = connect.createStatement();
            ResultSet result = st.executeQuery(sql);
            ResultSetMetaData meta = result.getMetaData();
            int count = meta.getColumnCount();
            for (int i = 1; i <= count; i++) {
                if (i == 1) {
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

    /**
     * 获取某个库下的所有表信息
     *
     * @param connect
     * @return
     */
    public static List<String> getTables(Connection connect, String sql) {
        List<String> list = new ArrayList<>();
        try {
            Statement st = connect.createStatement();
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                String tableName = result.getString(1);
                list.add(tableName);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取表的详情信息
     *
     * @param connect
     * @param database
     * @param tables
     * @return
     */
    public static Map<String, TableDesc> getTableDesc(Connection connect, String database, List<String> tables) {
        String sqlIn = "";
        for (String table : tables) {
            sqlIn = sqlIn + "'" + table + "',";
        }
        sqlIn = sqlIn.substring(0, sqlIn.lastIndexOf(","));
        String sql = "show table status from  " + database + "   where name in (" + sqlIn + ")";

        Map<String, TableDesc> map = new HashMap<>();
        try {
            Statement st = connect.createStatement();
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                String name = result.getString("Name");
                String engine = result.getString("Engine");
                String version = result.getString("Version");
                String row_format = result.getString("Row_format");
                String rows = result.getString("Rows");
                String avg_row_length = result.getString("Avg_row_length");
                String data_length = result.getString("Data_length");
                String max_data_length = result.getString("Max_data_length");
                String index_length = result.getString("Index_length");
                String data_free = result.getString("Data_free");
                String auto_increment = result.getString("Auto_increment");
                String create_time = result.getString("Create_time");
                String update_time = result.getString("Update_time");
                String check_time = result.getString("Check_time");
                String collation = result.getString("Collation");
                String checksum = result.getString("Checksum");
                String create_options = result.getString("Create_options");
                String comment = result.getString("Comment");

                TableDesc tableDesc = new TableDesc();
                tableDesc.setName(name).setEngine(engine).setVersion(version).setRowFormat(row_format)
                        .setRows(rows).setAvgRowLength(avg_row_length).setDataLength(data_length)
                        .setMaxDataLength(max_data_length).setIndexLength(index_length)
                        .setDataFree(data_free).setAutoIncrement(auto_increment)
                        .setCollation(collation).setChecksum(checksum).setCreateOptions(create_options)
                        .setComment(comment);
                map.put(name, tableDesc);
            }

            String sql2 = "select table_name, (data_length/1024/1024) as data_mb , (index_length/1024/1024) as index_mb, ((data_length+index_length)/1024/1024) as all_mb, table_rows from information_schema.tables " +
                    "where table_schema = '" + database + "'";

            ResultSet result2 = st.executeQuery(sql2);
            while (result2.next()) {
                String table_name = result2.getString("TABLE_NAME");
                String data_mb = result2.getString("data_mb");
                String index_mb = result2.getString("index_mb");
                String all_mb = result2.getString("all_mb");
                String table_rows = result2.getString("TABLE_ROWS");

                TableDesc tableDesc = map.get(table_name);
                tableDesc.setDataMb(data_mb).setIndexMb(index_mb).setAllMb(all_mb)
                        .setCount(table_rows);
            }

            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取表的详情信息
     * @param connect
     * @param database
     * @param tableName
     * @return
     */
    public static List<TableColumns> getTableColumns(Connection connect, String database, String tableName) {

        String sql = "show full columns from "+database+"."+tableName;
        List<TableColumns> list = new ArrayList<>();
        try {
            Statement st = connect.createStatement();
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                String field = result.getString("Field");
                String type = result.getString("Type");
                String collation = result.getString("Collation");
                String nullValue = result.getString("Null");
                String key = result.getString("Key");
                String defaultValue = result.getString("Default");
                String extra = result.getString("Extra");
                String privileges = result.getString("Privileges");
                String comment = result.getString("Comment");


                TableColumns columns = new TableColumns();
                columns.setField(field).setType(type).setCollation(collation)
                        .setNu(nullValue).setKey(key).setDefau(defaultValue)
                        .setExtra(extra).setPrivileges(privileges)
                        .setComment(comment);

               list.add(columns);
            }

            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取表索引信息
     *
     * @param connect
     * @return
     */
    public static List<TableIndex> getTableIndex(Connection connect, String sql) {

        List<TableIndex> list = new ArrayList<>();
        try {
            Statement st = connect.createStatement();
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                String table = result.getString("Table");
                String nonUnique = result.getString("Non_unique");
                String keyName = result.getString("Key_name");
                String seqInIndex = result.getString("Seq_in_index");
                String columnName = result.getString("Column_name");
                String collation = result.getString("Collation");
                String cardinality = result.getString("Cardinality");
                String subPart = result.getString("Sub_part");
                String packed = result.getString("Packed");
                String nullValue = result.getString("Null");
                String indexType = result.getString("Index_type");
                String comment = result.getString("Comment");
                String indexComment = result.getString("Index_comment");
                String visible = result.getString("Visible");
                String expression = result.getString("Expression");



                TableIndex index = new TableIndex();
                index.setTable(table).setNonUnique(nonUnique).setKeyName(keyName).setSeqInIndex(seqInIndex)
                        .setColumnName(columnName).setCollation(collation)
                        .setCardinality(cardinality).setSubPart(subPart)
                        .setPacked(packed).setNullValue(nullValue)
                        .setComment(comment).setIndexType(indexType).setIndexComment(indexComment)
                        .setVisible(visible).setExpression(expression);

                list.add(index);
            }

            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
