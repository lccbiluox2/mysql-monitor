package com.mysql.mointor.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.mointor.domain.NewsTable;
import com.mysql.mointor.service.NewsService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/newsIndexController") 
public class NewsIndexController {
	
	private Logger logger = Logger.getLogger(NewsIndexController.class);
	
	
	@Resource
	private NewsService newsService;
	
	
	/*
	 * 查看所有人的发布的新闻信息
	 * 
	 */
	@RequestMapping("/getAllNews") 
    public String  getAllNews(Model model,HttpServletRequest req,HttpServletResponse res) {
		List<NewsTable> list = newsService.getAllNews();
		model.addAttribute("newsList",list);
	    return "/index/news/newsList";
    }
    
	@RequestMapping("/showNewsDetailById") 
    public String  showNewsDetailById(Model model,int id,HttpServletRequest req,HttpServletResponse res) {
		NewsTable news = newsService.getNewsById(id);
		model.addAttribute("news",news);
	    return "/index/news/newsDetail";
	  
    }
	
}
