package com.neo.entity.dao;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 表索引信息
 */
@Data
@Accessors(chain = true)
public class TableIndex {
    private String table;
    private String nonUnique;
    private String keyName;
    private String seqInIndex;
    private String columnName;
    private String collation;
    private String cardinality;
    private String subPart;
    private String packed;
    private String nullValue;
    private String indexType;
    private String comment;
    private String indexComment;
    private String visible;
    private String expression;
}
