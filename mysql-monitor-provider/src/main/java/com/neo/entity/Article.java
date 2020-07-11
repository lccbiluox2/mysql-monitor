package com.neo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private Integer id;
    private String title;
    private Date ctime;
    private Date mtime;
    private Integer categoryId;
    private Integer categoryId1;
    private Integer categoryId2;
    private String address;
    private Integer contentId;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 简介
     */
    private String digest;
    /**
     * 文章类型 类型: 原创 转载 翻译
     */
    private String articleType;
    /**
     * 发布形式: 公开 私密 粉丝可见 VIP可见
     */
    private String modality;
    /**
     * 保存方式，主要用于区别数据从哪里来的，是先写的mysql还是先写的doc
     */
    private String saveMethod;
    /**
     * 关键字
     */
    private String keys;
}
