package com.neo.controller;

import com.neo.common.DubboResult;
import com.neo.entity.dao.DataBaseDao;
import com.neo.entity.req.DatabaseAddReq;
import com.neo.entity.response.DatabaseAddRes;
import com.neo.service.DatabaseService;
import com.neo.utils.JdbcSessionPlugin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return DubboResult.buildSuccessResult(list);
    }


    /**
     * 根据所有的数据库
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public DubboResult delete(@RequestBody DatabaseAddReq databaseAddReq) {
        int id = databaseAddReq.getId();
        System.out.println(id);
        databaseService.deleteById(id);
        return DubboResult.buildSuccessResult();
    }

    /**
     * 根据所有的数据库
     * @return
     */
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    @ResponseBody
    public DubboResult status() {
        List<DataBaseDao> list = databaseService.listAll();
        List<DatabaseAddRes> list1 = jdbcSessionPlugin.getDatabaseStatus(list);
        return DubboResult.buildSuccessResult(list1);
    }


}
