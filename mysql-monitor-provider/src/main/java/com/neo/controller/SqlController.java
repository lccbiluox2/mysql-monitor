package com.neo.controller;

import com.neo.common.DubboResult;
import com.neo.component.BasicFormatterImpl;
import com.neo.entity.dao.DataBaseDao;
import com.neo.entity.req.DatabaseAddReq;
import com.neo.entity.req.SqlMessage;
import com.neo.entity.response.DatabaseAddRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sql")
@Slf4j
public class SqlController {

    @Autowired
    private BasicFormatterImpl basicFormatterImpl;

    /**
     * 格式化sql
     *
     * @param sqlMessage
     * @return
     */
    @RequestMapping(value = "/format", method = RequestMethod.POST)
    @ResponseBody
    public DubboResult format(@RequestBody SqlMessage sqlMessage) {
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
    public DubboResult analyse(@RequestBody SqlMessage sqlMessage) {
        String sql = sqlMessage.getSql();
        if(sql == null){
            return DubboResult.buildSuccessResult();
        }
        // TODO: 基于代价的sql分析，先查询每个SQL的表数量
        // 判断SQL 类型 左连接 还是右连接
        // 分析出sql的 explain
        // 分析出来表信息，然后判断是否有索引
        String result = basicFormatterImpl.format(sql);
        return DubboResult.buildSuccessResult(result);
    }



}
