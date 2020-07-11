package com.neo.service.impl;

import com.neo.dao.ArticleDao;
import com.neo.dao.CategoryDao;
import com.neo.entity.Article;
import com.neo.entity.Category;
import com.neo.entity.dao.ArticleCount;
import com.neo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public Article getArticleByName(String newFileName) {
        return articleDao.getArticleByName(newFileName);
    }

    @Override
    public int insert(Article article) {
        return articleDao.insert(article);
    }

    @Override
    public void setContentId(int contentId, int articeId) {
        articleDao.setContentId(contentId, articeId);
    }

    @Override
    public List<Article> getArticleLikeName(String search) {
        return articleDao.getArticleLikeName(search);
    }

    @Override
    public List<Category> getArticleByCateId(Integer categoryId) {
        return articleDao.getArticleByCateId(categoryId);
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleDao.getArticleById(id);
    }

    @Override
    public List<ArticleCount> selectCount() {
        return articleDao.selectCount();
    }

    @Override
    public void updateArticle(Article article) {
        articleDao.updateArticle(article);
    }
}
