package com.neo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Content {
    private Integer id;
    private Integer titleId;
    private String digest;
    private String content;
    private Date ctime;
    private Date mtime;
}
