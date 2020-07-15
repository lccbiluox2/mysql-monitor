package com.neo.entity.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 表的主要信息是 TableDesc 的一个子集
 */
@Data
@Accessors(chain = true)
public class TableDescMain extends Tables {
    private String name;
    private String engine;
    private String rows;
    private String maxDataLength;
    private String autoIncrement;
    private String collation;

    private String dataMb;
    private String indexMb;
    private String allMb;
    private String count;
}
