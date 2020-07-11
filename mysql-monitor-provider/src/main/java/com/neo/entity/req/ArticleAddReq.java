package com.neo.entity.req;

import com.neo.entity.Article;
import lombok.Data;

@Data
public class ArticleAddReq extends Article {


    /**
     * 类别ids 逗号分隔
     */
    private String categoryIds;

}
