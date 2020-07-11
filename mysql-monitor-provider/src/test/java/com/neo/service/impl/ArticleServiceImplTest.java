package com.neo.service.impl;

import com.neo.BaseTest;
import com.neo.dao.ArticleDao;
import com.neo.entity.Article;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ArticleServiceImplTest extends BaseTest {

    @Autowired
    private ArticleDao articleDao;

    @Test
    public void getArticleByName() {
        Article result = articleDao.getArticleByName("95-65-010-编码解码-入门简介");
        System.out.println(result);
    }
}