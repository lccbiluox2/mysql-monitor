package com.neo.schedulertask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.neo.domain.IpcountBean;
import com.neo.service.IpcountBeanService;
import com.neo.utils.DateUtils;

/*
 * 这个类主要是处理一些统计IP访问网站信息的定时任务
 * 
 */

@Component
public class IpTask {

	 @Resource
	 private IpcountBeanService ipcountBeanService;
	
	 /*	cron表达式中各时间元素使用空格进行分割，分别表示如下含义：
	 	按顺序依次为
	 	秒（0~59）
	 	分钟（0~59）
	 	小时（0~23）
	 	天（月）（0~31，但是你需要考虑你月的天数）
	 	月（0~11）
	 	天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
	 	7.年份（1970－2099）*/
	 
	 //每天中午12点触发   去读取昨天的ip日志 并且加入数据库
	 //@Scheduled(cron="6 * * * * ?")
	 @Scheduled(cron="0 0 12 * * ?")
     private void process(){
		 //分析前一天的日志  得到map对象  ip为key   url为value
		 List<IpcountBean>   list = analyzeIp();
		 ipcountBeanService.addIpCount(list);
     }
	 
	 
	
	 
	
	 @SuppressWarnings("null")
	private  List<IpcountBean>   analyzeIp(){
		 //得到昨天日志的名称
		 String logName = "logs/countTimeLogger.log."+DateUtils.getYesterdayDateTime(DateUtils.yyyyMMddFormat);
		 System.out.println("=====log---------------"+logName);
		 File file = new File(logName);
		 
		 BufferedReader reader = null;
		 List<IpcountBean> list = new ArrayList<IpcountBean>(); 
		 try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while(((tempString = reader.readLine()) != null)){
				String[] a  = tempString.split("#");
				String time = a[0].substring(6, a[0].length()-11);
				String ip = a[1];
				String url = a[2];
				
				String[] times  =time.split(" ");
				String[] dates  =times[0].split("-");
				String year = dates[0];
				String month = dates[1] ;
				String day = dates[2];
				
				IpcountBean ipcountBean = new IpcountBean();
				//ipcountBean.setId();
				ipcountBean.setIp(ip);
				ipcountBean.setUrl(url);
				ipcountBean.setTime(time);
				ipcountBean.setYear(year);
				ipcountBean.setMonth(month);
				ipcountBean.setDay(day);
				
				list.add(ipcountBean);
			}
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 try {
			reader.close();
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }				
		return list;
	 }
 	 
	 
}
