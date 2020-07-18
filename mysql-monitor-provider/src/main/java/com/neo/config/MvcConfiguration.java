package com.neo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 这个类主要做的事直接访问html页面 不经过controller
 */
@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	/*
     * lcc  2017-03-5  10:04
     * 添加直接跳转页面的配置 不需要经过controller
     * 
     */
	  @Override  
	  public void addViewControllers(ViewControllerRegistry registry){
	      registry.addViewController("/admin/adminLogin").setViewName("background/login"); 

	      registry.addViewController("/newsController/toAddNewsPage").setViewName("background/news/addNews");
	      
	      
	      
	      
	  }  
  
	 //这里是自定义映射自己的静态资源目录的  
	  @Override
      public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 //这里是自定义映射自己的静态资源目录的  注释的这一行访问http://localhost:8080/upload/product/logo.jpg 相当于访问/static/img/目录下的logo.jpg图片
		//registry.addResourceHandler("/upload/product/**").addResourceLocations("classpath:/static/img/");
		
		  /*
		   * 下面是映射wepapp/upload/produce 映射成静态资源目录
		   * 刚开始写registry.addResourceHandler("/upload/product/**").addResourceLocations("classpath:/static/");
		   * 刚开始写registry.addResourceHandler("/upload/product/**").addResourceLocations("/upload/");
		   * 都不对
		   */
		registry.addResourceHandler("/upload/rent/**").addResourceLocations("/upload/rent/");
		registry.addResourceHandler("/upload/news/**").addResourceLocations("/upload/news/");
        super.addResourceHandlers(registry);
     }
  
}  
