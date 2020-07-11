package com.neo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Category {
    private Integer id;
    private String name;
    private Date ctime;
    private Date mtime;
    private String address;
}
