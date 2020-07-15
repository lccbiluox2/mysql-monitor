package com.neo.controller;

import com.neo.common.DubboResult;
import com.neo.entity.dao.DataBaseDao;
import com.neo.entity.req.DatabaseAddReq;
import com.neo.entity.response.DatabaseAddRes;
import com.neo.entity.response.TableDesc;
import com.neo.entity.response.TableDescMain;
import com.neo.service.DatabaseService;
import com.neo.service.TablesService;
import com.neo.utils.JdbcSessionPlugin;
import com.neo.utils.JdbcUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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

        List<TableDescMain> tableDescsMain = new ArrayList<>(list.size());
        for (TableDesc tableDesc : list){
            TableDescMain main = new TableDescMain();
            BeanUtils.copyProperties(tableDesc,main);
            tableDescsMain.add(main);
        }

        return DubboResult.buildSuccessResult(tableDescsMain);
    }


}
