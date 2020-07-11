package com.neo.service.impl;

import com.neo.dao.CategoryDao;
import com.neo.dao.CategoryMapDao;
import com.neo.entity.Category;
import com.neo.entity.CategoryMap;
import com.neo.service.CategoryMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryMapServiceImpl implements CategoryMapService {
    @Autowired
    private CategoryMapDao categoryMapDao;


    @Override
    public Map<String,String> getList() {
        List<CategoryMap> list = categoryMapDao.getList();
        Map<String,String> map = new HashMap<>(list.size());
        for (CategoryMap categoryMap:list){
            map.put(categoryMap.getDocName(),categoryMap.getCateName());
        }
        return map;
    }

}
