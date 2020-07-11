package com.neo.entity.dao;

import lombok.Data;

@Data
public class DataBaseDao {
    private int id;
    private String name;
    private String ip;
    private String username;
    private String password;
    private String database;
    private int port;
    private String status;
}
