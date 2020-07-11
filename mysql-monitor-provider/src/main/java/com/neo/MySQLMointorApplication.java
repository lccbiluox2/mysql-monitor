package com.neo;

import java.io.File;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.neo.utils.PathUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@EnableScheduling			//添加定时任务
@MapperScan("com.neo.dao")  //@MapperScan("com.neo.mapper") 这个注解如果没有 dao接口就无法直接调用*-mapper.xml中的sql
public class MySQLMointorApplication {

	
	//代码块初始化log4j日志
	static {
	      try{
	          //初始化log4j
	    	  //String filePath=root+"WEB-INF" + File.separator+"config"+File.separator+"log4j.properties"; 
	          String log4jPath = MySQLMointorApplication.class.getClassLoader().getResource("").getPath()+"log4j.properties";
	          System.out.println("初始化Log4j。。。。");
	          System.out.println("path is "+ log4jPath);
	          PropertyConfigurator.configure(log4jPath);
	          
	          //这一点想让日志输出到WEB-INF下 但是没起作用
	          String root=PathUtils.root();
	 		  String logFilesPath = root + "WEB-INF" + File.separator+ "logs";
	 		  System.setProperty("logFilesPath", logFilesPath);
	 		  System.out.println(System.getProperty("logFilesPath"));
	 		  PropertyConfigurator.configure(System.getProperties());
	          
	      }catch (Exception e){
	          e.printStackTrace();
	      }
	}


	/**
	 * 自定义错误处理页面  测试
	 */
	@Component
	public class ErrorPageResovler implements ErrorViewResolver {
		@Override
		public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
			ModelAndView mv = new ModelAndView();
			switch (status) {
				case NOT_FOUND:
					mv.setViewName("redirect:/errorPage/404.html");
					break;
				case UNAUTHORIZED:
					mv.setViewName("redirect:/errorPage/401.html");
					break;
				case INTERNAL_SERVER_ERROR:
					mv.setViewName("redirect:/errorPage/500.html");
					break;
				default:
					mv.setViewName("redirect:/err404.html");
			}
			return mv;
		}
	}


	
	public static void main(String[] args) {
		// 主类
		SpringApplication.run(MySQLMointorApplication.class, args);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
