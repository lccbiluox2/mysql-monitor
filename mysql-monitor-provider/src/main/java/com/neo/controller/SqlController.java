package com.neo.controller;

import com.neo.common.DubboResult;
import com.neo.component.BasicFormatterImpl;
import com.neo.entity.dao.DataBaseDao;
import com.neo.entity.req.SqlAnalyseReq;
import com.neo.service.DatabaseService;
import com.neo.utils.JdbcSessionPlugin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sql")
@Slf4j
public class SqlController {

    /**
     * SQL 格式化
     */
    @Autowired
    private BasicFormatterImpl basicFormatterImpl;
    /**
     * 数据库服务
     */
    @Autowired
    private DatabaseService databaseService;
    /**
     * jdbc插件
     */
    @Autowired
    private JdbcSessionPlugin jdbcSessionPlugin;


    /**
     * 格式化sql
     *
     * @param sqlMessage
     * @return
     */
    @RequestMapping(value = "/format", method = RequestMethod.POST)
    @ResponseBody
    public DubboResult format(@RequestBody SqlAnalyseReq sqlMessage) {
        String sql = sqlMessage.getSql();
        if(sql == null){
            return DubboResult.buildSuccessResult();
        }
        String result = basicFormatterImpl.format(sql);
        return DubboResult.buildSuccessResult(result);
    }

    /**
     * 分析 sql
     *
     * @param sqlMessage
     * @return
     */
    @RequestMapping(value = "/analyse", method = RequestMethod.POST)
    @ResponseBody
    public DubboResult analyse(@RequestBody SqlAnalyseReq sqlMessage) {
        String sql = sqlMessage.getSql();
        Integer databaseId = sqlMessage.getDatabase();
        String count = sqlMessage.getCount();
        if(sql == null){
            return DubboResult.buildSuccessResult();
        }

        DataBaseDao dataBaseDao = databaseService.selectById(databaseId);

        System.out.println(sqlMessage);

        // TODO: 基于代价的sql分析，先查询每个SQL的表数量
        // 判断SQL 类型 左连接 还是右连接
        // 分析出sql的 explain
        // 分析出来表信息，然后判断是否有索引
        String result = basicFormatterImpl.format(sql);
        return DubboResult.buildSuccessResult(result);
    }



}
