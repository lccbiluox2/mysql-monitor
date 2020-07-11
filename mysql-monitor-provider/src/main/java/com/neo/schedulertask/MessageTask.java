package com.neo.schedulertask;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.neo.service.MessageService;

/*
 * 这个类主要是处理一些关于留言信息的定时任务
 * 
 */

@Component
public class MessageTask {

	 @Resource
	 private MessageService messageService;
	
	 /*	cron表达式中各时间元素使用空格进行分割，分别表示如下含义：
	 	按顺序依次为
	 	秒（0~59）
	 	分钟（0~59）
	 	小时（0~23）
	 	天（月）（0~31，但是你需要考虑你月的天数）
	 	月（0~11）
	 	天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
	 	7.年份（1970－2099）*/
	 
	 //每天中午12点触发   去删除数据库中已经删除的留言信息
	 @Scheduled(cron="0 0 12 * * ?")
     private void process(){
		 System.out.println("删除数据库中已经删除的留言信息");
		 messageService.delMessageByCheckEquals3();
     }
	
}
