package com.neo.service.impl;

import com.neo.entity.Article;
import com.neo.entity.req.SearchText;
import com.neo.service.ArticleService;
import com.neo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private ArticleService articleService;

    @Override
    public List<Article> search(SearchText searchText) {
        String search = searchText.getSearchText();
        List<Article>  list = articleService.getArticleLikeName(search);
        return list;
    }
}
