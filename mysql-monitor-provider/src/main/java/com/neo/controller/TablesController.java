package com.neo.controller;

import com.neo.common.DubboResult;
import com.neo.entity.dao.DataBaseDao;
import com.neo.entity.req.DatabaseAddReq;
import com.neo.entity.response.DatabaseAddRes;
import com.neo.entity.response.TableDesc;
import com.neo.service.DatabaseService;
import com.neo.service.TablesService;
import com.neo.utils.JdbcSessionPlugin;
import com.neo.utils.JdbcUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
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

        Map<String, TableDesc> list = JdbcUtils.getTableDesc(connect, database, tables);
        return DubboResult.buildSuccessResult(list);
    }


}
