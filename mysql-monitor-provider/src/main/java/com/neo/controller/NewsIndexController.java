package com.neo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neo.domain.NewsTable;
import com.neo.domain.RentTable;
import com.neo.domain.UserTable;
import com.neo.service.NewsService;
import com.neo.utils.DateUtils;
import com.neo.utils.UploadImgToPointDir;

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
