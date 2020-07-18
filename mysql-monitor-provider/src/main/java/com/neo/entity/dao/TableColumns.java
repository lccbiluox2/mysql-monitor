package com.neo.entity.dao;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 *
 */
@Data
@Accessors(chain = true)
public class TableColumns {
    private String field     ;
    private String  type      ;
    private String collation ;
    private String nu;
    private String key ;
    private String defau ;
    private String extra       ;
    private String privileges    ;
    private String  comment ;
}
