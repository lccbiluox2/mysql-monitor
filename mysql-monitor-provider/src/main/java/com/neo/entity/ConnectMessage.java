package com.neo.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ConnectMessage {
    @NotNull(message = "名称不能为空")
    private String name;
    @NotNull(message = "连接地址不能为空")
    private String connectUrl;
    private String userName;
    protected String password;
}