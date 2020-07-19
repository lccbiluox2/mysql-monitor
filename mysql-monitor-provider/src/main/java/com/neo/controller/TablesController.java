package com.neo.controller;

import com.neo.common.DubboResult;
import com.neo.entity.dao.DataBaseDao;
import com.neo.entity.dao.TableColumns;
import com.neo.entity.dao.TableIndex;
import com.neo.entity.req.TableDetailReq;
import com.neo.entity.response.*;
import com.neo.service.DatabaseService;
import com.neo.service.TablesService;
import com.neo.utils.JdbcSessionPlugin;
import com.neo.utils.JdbcUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.util.*;

@RestController
@RequestMapping("/tables")
@Slf4j
public class TablesController {

    @Autowired
    private DatabaseService databaseService;

    @Autowired
    private TablesService tablesService;

    @Autowired
    private JdbcSessionPlugin jdbcSessionPlugin;

    /**
     * 根据类别获取文章
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public DubboResult list(@RequestBody DataBaseDao dataBaseDao) {
        int id = dataBaseDao.getId();
        dataBaseDao = databaseService.selectById(id);
        String database = dataBaseDao.getDatabase();
        Connection connect = jdbcSessionPlugin.getConnect(dataBaseDao);
        List<String> tables = JdbcUtils.getTables(connect,"show tables in "+database );

        Map<String, TableDesc> map = JdbcUtils.getTableDesc(connect, database, tables);
        Collection<TableDesc> collection = map.values();
        List<TableDesc> list =  new ArrayList<>(collection);

        List<Tables> tableDescsMain = new ArrayList<>(list.size());
        List<Tables> tableDescsOther = new ArrayList<>(list.size());
        for (TableDesc tableDesc : list){
            TableDescMain main = new TableDescMain();
            TableDescOhter other = new TableDescOhter();
            BeanUtils.copyProperties(tableDesc,main);
            BeanUtils.copyProperties(tableDesc,other);
            tableDescsMain.add(main);
            tableDescsOther.add(other);
        }

        Map<String, List<Tables>> mapreturn = new HashMap<>(2);
        mapreturn.put("tableDescsMain",tableDescsMain);
        mapreturn.put("tableDescsOther",tableDescsOther);

        return DubboResult.buildSuccessResult(mapreturn);
    }



    /**
     * 获取某个表的详情信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @ResponseBody
    public DubboResult detail(@RequestBody TableDetailReq tableDetailReq) {
        int id = tableDetailReq.getId();
        String tableName = tableDetailReq.getName();
        DataBaseDao dataBaseDao = databaseService.selectById(id);
        String database = dataBaseDao.getDatabase();

        Connection connect = jdbcSessionPlugin.getConnect(dataBaseDao);

        Map<String, String> createTable = JdbcUtils.getVariables(connect,"show create table "+database+"."+tableName+"");
        List<TableColumns> tableColumns = JdbcUtils.getTableColumns(connect,database,tableName);

        List<TableIndex> tableIndex = JdbcUtils.getTableIndex(connect,"show index from "+database+"."+tableName+"");


        TableDetailRes tableDetailRes = new TableDetailRes();
        tableDetailRes.setCreateTable(createTable);
        tableDetailRes.setTableColumns(tableColumns);
        tableDetailRes.setTableIndex(tableIndex);

        return DubboResult.buildSuccessResult(tableDetailRes);
    }

}
