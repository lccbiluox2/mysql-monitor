package com.neo.service.impl;

import com.neo.dao.CategoryDao;
import com.neo.dao.MessageDao;
import com.neo.domain.MessageTable;
import com.neo.entity.Category;
import com.neo.entity.CategoryMap;
import com.neo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;


    @Override
    public List<Category> getList() {
        List<Category> list = categoryDao.getList();
        return list;
    }

    @Override
    public Map<String ,Integer> getMap() {
        List<Category> list = categoryDao.getList();
        Map<String ,Integer> categoryMap = new HashMap<>();
        for (Category category:list){
            categoryMap.put(category.getName(),category.getId());
        }
        return categoryMap;
    }

    @Override
    public Category getCategoryByName(String categoryName) {
//        return categoryDao.getCategoryByName(categoryName);
        return null;
    }
}
