package com.neo.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neo.bean.WebBean;
import com.neo.chart.MyIpChart;
import com.neo.properties.MyProperties;
import com.neo.query.IpBrokenLineQuery;
import com.neo.service.IpcountBeanService;
import com.neo.utils.DateUtils;


@Controller
@RequestMapping("/indexController") 
public class IndexController {
   
	private Logger logger = Logger.getLogger(IndexController.class);
	
	
	 @Resource
	 private IpcountBeanService ipcountBeanService;
    
    @RequestMapping("/welcome") 
    public String  welcome(Model model,HttpServletRequest req,HttpServletResponse res) {
    	
    	/*****************************折线图处理开始************************************************/
    	
    	//获得年月日  格式  2017   03  23
        String year = DateUtils.getYear();
        String month = DateUtils.getMonth();
        String day = DateUtils.getDay();
        //根据天分组查寻
        Map<String,String> map=new HashMap<String,String>();
		map.put("year",year);
		map.put("month",month);
		map.put("day",day);
		
		//在/chat文件夹下生成名字如 2017-03-12.jpg的访问图表
		String pathDir =  "/chat" ;
		String path2 = req.getSession().getServletContext().getRealPath(pathDir);
		String newFileName = year+"-"+month+"-"+day;
	    newFileName =  "/"+newFileName+".jpg" ;
	    
	    //本来想写到task 定时任务中的  但是发现  需要一个request无法传入进去   所以改成每天第一个访问的时候生成改天以前到今天的图表
	    File fileAllreadyExist = new File(path2+newFileName);
	    if(fileAllreadyExist.exists()){
	    	//文件今天已经生成   
	    	System.out.println("今天的图表已经生成，不用再次生成");
	    }else{
	    	
	    	 List<IpBrokenLineQuery> blList = ipcountBeanService.getCountByIp(map);
	         
	         //组织整理成map数据    key是年月日   value是当天的访问量
	         List<IpBrokenLineQuery> blList2= new ArrayList<IpBrokenLineQuery>();
	         for(int i=0;i<blList.size();i++){
	        	 	IpBrokenLineQuery a = blList.get(i);
	        	 	a.setTime(a.getYear()+"-"+a.getMonth()+"-"+a.getDay());
	        	    blList2.add(a);
	         }
	         //这一点要用TreeMap按key排序 就是按照时间排序
	         Map<String,Integer> clickCountMap= new  TreeMap<String,Integer> ();;
	         for(int i=0;i<blList2.size();i++){
	        	   System.out.println("今天的图表已经生成，不用再次生成"+blList2.get(i).getTime());
	        	    clickCountMap.put(blList2.get(i).getTime(), blList2.get(i).getMycount());
	         }
	    	MyIpChart my = new MyIpChart(clickCountMap, path2, newFileName);
	   }
	    
	    
       
        
	    
	   
        String zhexianUrl = "/chat/"+newFileName;
        model.addAttribute("zhexianUrl", zhexianUrl);
        
        /*****************************折线图处理结束************************************************/
        
        //网站访问次数
        String filePath = req.getSession().getServletContext().getRealPath("/myproperties/webCount.properties");
        MyProperties properties = new MyProperties();
        int num = properties.readProperties("count", filePath);
    	model.addAttribute("clickCount", num);
	    return "index" ;  
    }
    
    
    
    
}