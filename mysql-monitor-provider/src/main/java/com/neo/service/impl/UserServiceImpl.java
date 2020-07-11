package com.neo.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.dao.UserDao;
import com.neo.domain.UserTable;
import com.neo.service.UserService;

@Service
public class UserServiceImpl implements  UserService{
	
	@Autowired
	private UserDao userDao;


	@Override
	public boolean isLogin(UserTable user, HttpServletRequest req, HttpServletResponse res) {
		
		UserTable userByName = userDao.getUserByName(user.getUser_name()); 
		//这一点字符串判断相等 要用equals方法
		if(  user.getUser_passwd().equals(userByName.getUser_passwd())  ) {
			//将用户存储到session中
			HttpSession session =  req.getSession();
	        //将数据存储到session中
			//保存用戶名和密碼
			session.setAttribute("admin", userByName);
			
			return true;
		}else{
			return false;
		}
	}


	@Override
	public void addUser(UserTable user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}
	
	
	
	

}

