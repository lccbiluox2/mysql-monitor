package com.neo.controller;

import com.neo.common.DubboResult;
import com.neo.entity.dao.DataBaseDao;
import com.neo.entity.req.DatabaseAddReq;
import com.neo.entity.response.DataBaseDetaiRes;
import com.neo.entity.response.DatabaseAddRes;
import com.neo.service.DatabaseService;
import com.neo.utils.JdbcSessionPlugin;
import com.neo.utils.JdbcUtils;
import com.neo.utils.SystemValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/database")
@Slf4j
public class DatabaseController {


    @Autowired
    private DatabaseService databaseService;

    @Autowired
    private JdbcSessionPlugin jdbcSessionPlugin;

    /**
     * 根据类别获取文章
     *
     * @param databaseAddReq
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public DubboResult add(@RequestBody DatabaseAddReq databaseAddReq) {
        DataBaseDao dataBaseDao = new DataBaseDao();
        BeanUtils.copyProperties(databaseAddReq,dataBaseDao);

        databaseService.insert(dataBaseDao);

        DatabaseAddRes databaseAddRes = new DatabaseAddRes();
        BeanUtils.copyProperties(databaseAddReq,databaseAddRes);
        return DubboResult.buildSuccessResult(databaseAddRes);
    }


    /**
     * 根据所有的数据库
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DubboResult list() {
        List<DataBaseDao> list = databaseService.listAll();
        List<DatabaseAddRes> list1 = jdbcSessionPlugin.getDatabaseStatus(list);
        return DubboResult.buildSuccessResult(list1);
    }


    /**
     * 根据所有的数据库
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public DubboResult delete(@RequestBody DatabaseAddReq databaseAddReq) {
        int id = databaseAddReq.getId();
        databaseService.deleteById(id);
        return DubboResult.buildSuccessResult();
    }


    /**
     * 根据所有的数据库
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @ResponseBody
    public DubboResult detail(@RequestBody DatabaseAddReq databaseAddReq) {
        int id = databaseAddReq.getId();
        DataBaseDao dataBaseDao = databaseService.selectById(id);

        String mySQLHome = SystemValue.getCustomProperties("MYSQL_HOME");

        Connection connect = jdbcSessionPlugin.getConnect(dataBaseDao);
        String basedir = JdbcUtils.getVariable(connect,"Value","show variables like '%basedir%'");
        String version = JdbcUtils.getVariable(connect,"version","select version() as version");
        String datadir = JdbcUtils.getVariable(connect,"Value","show variables like '%datadir%'");

        String database = dataBaseDao.getDatabase();
        Map<String, String>  dbSize = JdbcUtils.getDbSize(connect,database);

        Map<String, String> charMap = JdbcUtils.getVariables(connect,"show variables like \"char%\"");
        Map<String, String> logError = JdbcUtils.getVariables(connect,"SHOW VARIABLES LIKE 'log_error'");
        Map<String, String> logBin = JdbcUtils.getVariables(connect,"SHOW VARIABLES LIKE 'log_error'");
        Map<String, String> generalLog = JdbcUtils.getVariables(connect,"SHOW VARIABLES LIKE '%general%';");
        Map<String, String> slowQueryLog = JdbcUtils.getVariables(connect," SHOW VARIABLES LIKE 'slow_query%'");
        Map<String, String> maxConnecttion = JdbcUtils.getVariables(connect," show variables like '%max_connections%' ");
        Map<String, String> connections = JdbcUtils.getVariables(connect," show status like 'connections'; ");
        maxConnecttion.putAll(connections);


        Map<String, String> threadsCached = JdbcUtils.getVariables(connect," show status like 'threads_cached' ");
        Map<String, String> threadsConnected = JdbcUtils.getVariables(connect," show status like 'threads_connected' ");
        Map<String, String> threadsCreated = JdbcUtils.getVariables(connect," show status like 'threads_created' ");
        Map<String, String> threadsRunning = JdbcUtils.getVariables(connect," show status like 'threads_running' ");
        Map<String, String> slowLaunchThreads = JdbcUtils.getVariables(connect," show status like 'slow_launch_threads' ");
        threadsCached.putAll(threadsConnected);
        threadsCached.putAll(threadsCreated);
        threadsCached.putAll(threadsRunning);
        threadsCached.putAll(slowLaunchThreads);

        Map<String, String> tableLock = JdbcUtils.getVariables(connect," show status like 'table%' ");

        Map<String, String> variables = JdbcUtils.getALlVariable(connect);

        DataBaseDetaiRes detail = new DataBaseDetaiRes();
        detail.setMySqlHome(mySQLHome);
        detail.setBasedir(basedir);
        detail.setVariables(variables);
        detail.setVersion(version);
        detail.setCharMap(charMap);
        detail.setLogError(logError);
        detail.setLogBin(logBin);
        detail.setGeneralLog(generalLog);
        detail.setSlowQueryLog(slowQueryLog);
        detail.setMaxConnecttion(maxConnecttion);
        detail.setThreads(threadsCached);
        detail.setTableLock(tableLock);
        detail.setDatadir(datadir);
        detail.setDbSize(dbSize);

        return DubboResult.buildSuccessResult(detail);
    }



}
