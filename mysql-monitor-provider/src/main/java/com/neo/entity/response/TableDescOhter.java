package com.neo.entity.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TableDescOhter extends Tables {


    private String name;
    private String rowFormat;
    private String avgRowLength;
    private String dataLength;
    private String indexLength;
    private String dataFree;
    private String createTime;
    private String updateTime;
    private String checkTime;
    private String checksum;
    private String createOptions;
    private String comment;

}
