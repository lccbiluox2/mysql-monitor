package com.neo.dao;

import com.neo.entity.Article;
import com.neo.entity.Category;
import com.neo.entity.dao.ArticleCount;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ArticleDao {

    Article getArticleByName(String newFileName);

    int insert(Article article);

    void setContentId(@Param("contentId") int contentId,@Param("id")  int id);

    List<Article> getArticleLikeName(@Param("title") String title);

    List<Category> getArticleByCateId(@Param("category") Integer categoryId);

    Article getArticleById(@Param("id") Integer id);

    /**
     * 根据类别统计，每个类别下写了多少篇文章
     * @return Map<类别ID, 数量>
     */
    List<ArticleCount> selectCount();

    void updateArticle(Article article);
}
