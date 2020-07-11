package com.neo.entity.response;

import com.neo.entity.Article;
import lombok.Data;

@Data
public class ArticleDetail extends Article {
    private String imagePath;
}
