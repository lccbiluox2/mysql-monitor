package com.neo.filter;

import com.neo.log4j.MyLog4j;
import com.neo.properties.MyProperties;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*
 * 这个类是过滤类  请求处理之前过滤
 * 
 */
public class MyFilter implements Filter {
	
	private Logger logger = Logger.getLogger(MyFilter.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
		System.out.println("=================");
	}


	@Override
	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) srequest;
		System.out.println("this is MyFilter,url :"+request.getRequestURI());// /welcome
		
		/*System.out.println("this is MyFilter,url :"+request.getLocalAddr());// 0:0:0:0:0:0:0:1
		System.out.println("this is MyFilter,url :"+request.getLocalName());//0:0:0:0:0:0:0:1
		System.out.println("this is MyFilter,url :"+request.getLocalPort());//8080
		System.out.println("this is MyFilter,url :"+request.getMethod());//GET
		System.out.println("this is MyFilter,url :"+request.getPathInfo());//null
		System.out.println("this is MyFilter,url :"+request.getPathTranslated());//null
		System.out.println("this is MyFilter,url :"+request.getProtocol());//HTTP/1.1
		System.out.println("this is MyFilter,url :"+request.getQueryString());//null
		System.out.println("this is MyFilter,url :"+request.getRemoteAddr());//0:0:0:0:0:0:0:1 前一个是获得客户端的ip地址 
		System.out.println("this is MyFilter,url :"+request.getRemoteHost());//0:0:0:0:0:0:0:1 后一个是获得客户端的主机名
		System.out.println("this is MyFilter,url :"+request.getRemoteUser());//null
		System.out.println("this is MyFilter,url :"+request.getServerName());//localhost
		System.out.println("this is MyFilter,url :"+request.getServerPort());//8080
		System.out.println("this is MyFilter,url :"+request.getServletPath());///welcome
		System.out.println("this is MyFilter,url :"+request.getAttributeNames());//java.util.Collections$3@9cc5045
*/		
		//这里只统计用户访问首页的次数
		if( request.getRequestURI().equals("/indexController/welcome") ){
			//2017-3-14 lcc 修改    把网站访问量进行持久化操作   写入到properties文件中
			String filePath = request.getSession().getServletContext().getRealPath("/myproperties/webCount.properties");
			MyProperties properties = new MyProperties();
	        int num = properties.readProperties("count", filePath)+1;
	        properties.saveProperties("count", num+"", filePath);
		}
		
		//这一点是自定义日志  用来输出到logs/countTimeLogger.log   文件里  统计ip访问到哪些网页
		MyLog4j.countTimeLog("host#"+request.getRemoteAddr()+"#"+request.getRequestURI());
		
		
		filterChain.doFilter(srequest, sresponse);
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
	

}