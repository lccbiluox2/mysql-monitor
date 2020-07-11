package com.neo.service;

import com.neo.entity.Article;
import com.neo.entity.Category;
import com.neo.entity.dao.ArticleCount;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    Article getArticleByName(String newFileName);

    /**
     * 插入文章名称
     * @param article
     * @return
     */
    int insert(Article article);

    void setContentId(int contentId, int articeId);

    List<Article> getArticleLikeName(String search);

    List<Category> getArticleByCateId(Integer categoryId);

    Article getArticleById(Integer titleId);

    /**
     * 根据类别统计，每个类别下写了多少篇文章
     * @return Map<类别ID, 数量>
     */
    List<ArticleCount> selectCount();

    /**
     * 更新文章信息
     * @param article
     */
    void updateArticle(Article article);
}
