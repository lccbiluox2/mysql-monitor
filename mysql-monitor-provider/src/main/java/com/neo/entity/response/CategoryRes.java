package com.neo.entity.response;

import com.neo.entity.Category;
import lombok.Data;

@Data
public class CategoryRes extends Category {
    private Integer count;
}
