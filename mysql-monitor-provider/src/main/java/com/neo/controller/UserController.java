package com.neo.controller;

import java.io.IOException;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.neo.domain.UserTable;
import com.neo.service.UserService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/userController") 
public class UserController {

	private Logger logger = Logger.getLogger(UserController.class);
	
	@Resource
	private UserService userService;
	
	
	
	
	
	
    
    //转到管理员登录
    @RequestMapping("/toAdminLogin") 
    public String  toAdminLogin(Model model,HttpServletRequest req,HttpServletResponse res) {
    	return "background/login_pre";
    }
    
	/*
	 * ajax实现管理员登录
	 * 
	 */
	@RequestMapping("/adminLogin") 
    public String  adminLogin(Model model,UserTable user,HttpServletRequest req,HttpServletResponse res) {
		//查寻用户在不在数据库  并且添加到session
	    boolean flag = userService.isLogin(user,req,res);
	    if(flag){
	    	List<String> u = new ArrayList<String>() ;
			PrintWriter out = null;
			try {
				out = res.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(flag){
				u.add("1");//登录成功
			}else{
				u.add("0");//登录失败
			}
			String s = JSONArray.fromObject(u).toString();
			out.print(s);
			out.close();
	    }
	    return null;
    }
	
	
	
	//转到后台主页面
	@RequestMapping("/index") 
    public String  toBackIndex(Model model,HttpServletRequest req,HttpServletResponse res) {
		
		//将用户存储到session中
		HttpSession session =  req.getSession();
        //将数据存储到session中
		//保存用戶名和密碼
		UserTable user = (UserTable) session.getAttribute("admin");
		if(user == null){
			model.addAttribute("admin", user);
		}
		
	    return "background/index";
	  
	   
    }
	
	
	//转到普通用户登录
	@RequestMapping("/userLogin") 
    public String  userLogin(Model model,HttpServletRequest req,HttpServletResponse res) {
	    return "index/user/user_login";
    }
	
	//转到普通用户注册
	@RequestMapping("/userRegister") 
    public String  userRegister(Model model,HttpServletRequest req,HttpServletResponse res) {
	    return "index/user/user_register";
    }
	
	
	@RequestMapping("/userLoginReal") 
    public String  userLoginReal(Model model,UserTable user,HttpServletRequest req,HttpServletResponse res) {
		//查寻用户在不在数据库  并且添加到session
	    boolean flag = userService.isLogin(user,req,res);
	    if(flag){
	    	return "redirect:/messageIndexController/preAddMessagePage?currentPage=0";
	    }
	    return "redirect:/userController/userLogin";
    }
	
	
	@RequestMapping("/userRegisterReal") 
    public String  userRegisterReal(Model model,UserTable user,HttpServletRequest req,HttpServletResponse res) {
	    userService.addUser(user);
	    return "redirect:/indexController/welcome";
	    
    }
	
	
	@RequestMapping("/loginOut") 
    public String  loginOut(Model model,HttpServletRequest req,HttpServletResponse res) {
		
		//将用户存储到session中
		HttpSession session =  req.getSession();
	
		//手工调用session.invalidate方法，摧毁session
		session.invalidate();
		
	    return "redirect:/indexController/welcome";
	  
	   
    }
	
	
	
}
