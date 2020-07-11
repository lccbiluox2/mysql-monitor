package com.neo.dao;

import com.neo.entity.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> getList();

//    Category getCategoryByName(String categoryName);
}
