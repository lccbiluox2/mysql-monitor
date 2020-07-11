package com.neo.controller;

import com.neo.bean.PageBean;
import com.neo.common.DubboResult;
import com.neo.entity.Category;
import com.neo.entity.dao.ArticleCount;
import com.neo.entity.req.SearchText;
import com.neo.entity.response.CategoryRes;
import com.neo.service.ArticleService;
import com.neo.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DubboResult<List<CategoryRes>> showAllMessage() {
        //分页准备数据2017/3/10
        List<Category> list = categoryService.getList();
        List<ArticleCount> articleCountList = articleService.selectCount();
        Map<Integer,Integer> map = new HashMap<>();
        for (ArticleCount articleCount:articleCountList){
            map.put(articleCount.getCategory(),articleCount.getCount());
        }
        List<CategoryRes> cateList =  new ArrayList<>();
        for (Category category:list){
            Integer cateId = category.getId();
            Integer count = map.get(cateId);
            CategoryRes categoryRes = new CategoryRes();
            BeanUtils.copyProperties(category,categoryRes);
            categoryRes.setCount(count);
            cateList.add(categoryRes);
        }
        return DubboResult.buildSuccessResult(cateList);
    }


}
