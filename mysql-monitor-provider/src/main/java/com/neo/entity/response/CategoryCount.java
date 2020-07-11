package com.neo.entity.response;

import com.neo.entity.Article;
import com.neo.entity.Content;
import lombok.Data;

@Data
@Deprecated
public class CategoryCount {
    private Article article;
    private Content content;
}
