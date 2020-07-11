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
@RequestMapping("/newsController") 
public class NewsController {

	private Logger logger = Logger.getLogger(NewsController.class);
	
	
	@Resource
	private NewsService newsService;
	
	
	//添加出租信息
	@RequestMapping("/addNews") 
    public String  addNews(Model model,NewsTable news,HttpServletRequest req,HttpServletResponse res) {
		
		HttpSession session =  req.getSession();
		UserTable user = (UserTable) session.getAttribute("admin");
		
		if(user == null){
			return "redirect:/userController/toAdminLogin";
		}
		
		news.setCreate_time(DateUtils.getFormatDateTime(new Date(), DateUtils.yyyyMMddFormat));
		
		news.setUser_id(user.getId());
		news.setUser_name(user.getUser_name());
		
		newsService.addnews(news);
	    return null;
	  
    }
	
	//添加news信息 添加news信息内容的时候 会是图文混排序 这里是上传单张图片的
	@SuppressWarnings("unchecked")
	@RequestMapping("/addNewsPicture") 
    public void  addNewsPicture(Model model,HttpServletRequest req,HttpServletResponse res) {
		
		// 图片
		String uploadfileDir = "/upload/news";
		String newFileName = UploadImgToPointDir.getDate();
		String fileNameString = UploadImgToPointDir.uploadImgToPointDir2(
				req, uploadfileDir, newFileName);
		if (!fileNameString.equals(newFileName)) {
			String filePath =  uploadfileDir + "/"+ fileNameString.trim();
			PrintWriter out = null;
			try {
				out = res.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JSONObject obj = new JSONObject();
			obj.put("error", 0);
			obj.put("url", filePath);
			
			out.println(obj.toJSONString());
		}
	    return;
    }
	

	/*
	 * 根据不同的人 查询各自发布的信息  管理员可以查看所有人的信息
	 * 
	 */
	@RequestMapping("/getAllNewsByUser") 
    public String  getAllNewsByUser(Model model,HttpServletRequest req,HttpServletResponse res) {
		
		HttpSession session =  req.getSession();
		UserTable user = (UserTable) session.getAttribute("admin");
		
		if(user == null){
			return "redirect:/userController/toAdminLogin";
		}
		
		List<NewsTable> list = newsService.getAllNewsByUser(user);
		
		for(int i=0;i<list.size();i++){
			System.out.println("================"+list.get(i).toString());
		}
		
		model.addAttribute("List",list );
	
		return "/background/news/newsListByUser";
	  
    }
	
	// 根据id删除rent信息
	@RequestMapping("/deleteNewsById") 
    public String  deleteNewsById(Model model,int id,HttpServletRequest req,HttpServletResponse res) {
		newsService.deleteNewsById(id);
		return "redirect:/newsController/getAllNewsByUser";
	  
    }
	
	// 根据id修改news信息  先根绝id查询信息 然后回显在页面上
	@RequestMapping("/preUpdateNewsById") 
    public String  preUpdateRentById(Model model,int id,HttpServletRequest req,HttpServletResponse res) {
		NewsTable news = newsService.getNewsById(id);
		
		System.out.println(news.toString());
		
		model.addAttribute("item",news );
		return "/background/news/updateNews";
	  
    }
	// 根据id修改rent信息  
	@RequestMapping("/updateNewsById") 
    public String  updateNewsById(Model model,NewsTable news,HttpServletRequest req,HttpServletResponse res) {
		
		System.out.println(news.toString());
		
		HttpSession session =  req.getSession();
		UserTable user = (UserTable) session.getAttribute("admin");
		
		if(user == null){
			return "redirect:/userController/toAdminLogin";
		}
		
		news.setCreate_time(DateUtils.getFormatDateTime(new Date(), DateUtils.yyyyMMddFormat));
		
		news.setUser_id(user.getId());
		news.setUser_name(user.getUser_name());
		
		newsService.updateNewsById(news);
		
		return "redirect:/newsController/getAllNewsByUser";
	  
    }
}
