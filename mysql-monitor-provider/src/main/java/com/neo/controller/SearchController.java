package com.neo.controller;

import com.neo.common.DubboResult;
import com.neo.domain.RentTable;
import com.neo.entity.Article;
import com.neo.entity.Category;
import com.neo.entity.req.SearchText;
import com.neo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/searchController")
public class SearchController {

//    @Autowired
//    private SearchService searchService;
//
//    /**
//     * 搜索栏搜索 博客
//     * @param searchText
//     * @return
//     */
//    @RequestMapping(value = "/search", method = RequestMethod.POST)
//    @ResponseBody
//    public DubboResult<List<Article>> search(@RequestBody SearchText searchText) {
//        List<Article> list = searchService.search(searchText);
//        return DubboResult.buildSuccessResult(list);
//    }
}
