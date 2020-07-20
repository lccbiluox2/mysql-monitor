package com.neo.entity.req;

import lombok.Data;

@Data
public class SqlAnalyseReq {
    /**
     * 页面传入的SQl
     */
    private String sql;
    /**
     * 页面传入的database id
     */
    private Integer database;
    /**
     * 页面传入的SQl执行次数
     */
    private String count;
}
