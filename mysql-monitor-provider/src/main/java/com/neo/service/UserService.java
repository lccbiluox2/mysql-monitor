package com.neo.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.domain.UserTable;

public interface UserService {

	//判断用户是否存在数据库
	boolean isLogin(UserTable user, HttpServletRequest req, HttpServletResponse res);

	void addUser(UserTable user);

	
	


}
