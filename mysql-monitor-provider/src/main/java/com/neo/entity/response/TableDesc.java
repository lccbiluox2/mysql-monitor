package com.neo.entity.response;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TableDesc {

    private String name;
    private String engine;
    private String version;
    private String rowFormat;
    private String rows;
    private String avgRowLength;
    private String dataLength;
    private String maxDataLength;
    private String indexLength;
    private String dataFree;
    private String autoIncrement;
    private String createTime;
    private String updateTime;
    private String checkTime;
    private String collation;
    private String checksum;
    private String createOptions;
    private String comment;

    private String dataMb;
    private String indexMb;
    private String allMb;
    private String count;
}
