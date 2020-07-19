package com.neo.entity.req;

import lombok.Data;

@Data
public class SqlMessage {
    /**
     * 页面传入的SQl
     */
    private String sql;
}
