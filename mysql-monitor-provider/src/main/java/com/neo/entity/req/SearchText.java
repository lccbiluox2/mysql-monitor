package com.neo.entity.req;

import lombok.Data;

@Data
public class SearchText {
    private String searchText;
    private String categoryName;
    private Integer categoryId;
}
