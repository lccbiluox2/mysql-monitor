package com.mysql.mointor;

import java.io.File;

import org.apache.log4j.PropertyConfigurator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.mysql.mointor.utils.PathUtils;

@SpringBootApplication
@EnableScheduling			//添加定时任务
@MapperScan("com.neo.dao")  //@MapperScan("com.neo.mapper") 这个注解如果没有 dao接口就无法直接调用*-mapper.xml中的sql
public class Application {

	
	//代码块初始化log4j日志
	static {
	      try{
	          //初始化log4j
	    	  //String filePath=root+"WEB-INF" + File.separator+"config"+File.separator+"log4j.properties"; 
	          String log4jPath = Application.class.getClassLoader().getResource("").getPath()+"log4j.properties";
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
	

	
	//自定义错误处理页面  测试
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
	   return (container -> {
	        ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/errorPage/401.html");
	        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/errorPage/404.html");
	        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/errorPage/500.html");
	        container.addErrorPages(error401Page, error404Page, error500Page);
	   });
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
