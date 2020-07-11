package com.neo.dao;

import com.neo.entity.CategoryMap;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapDao {
    List<CategoryMap> getList();
}
