package com.neo.service;

import com.neo.entity.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    List<Category> getList();

    Map<String, Integer> getMap();

    Category getCategoryByName(String categoryName);
}
