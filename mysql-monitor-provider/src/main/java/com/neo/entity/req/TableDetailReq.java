package com.neo.entity.req;

import lombok.Data;

@Data
public class TableDetailReq {
    /**
     * 数据库ID
     */
    private Integer id;
    /**
     * 表名称
     */
    private String name;
}
