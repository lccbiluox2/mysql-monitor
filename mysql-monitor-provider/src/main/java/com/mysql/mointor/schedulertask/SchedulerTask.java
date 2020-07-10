package com.mysql.mointor.schedulertask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {
	
	 	//private int count=0;

	 /*	cron表达式中各时间元素使用空格进行分割，分别表示如下含义：
	 	按顺序依次为
	 	秒（0~59）
	 	分钟（0~59）
	 	小时（0~23）
	 	天（月）（0~31，但是你需要考虑你月的天数）
	 	月（0~11）
	 	天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
	 	7.年份（1970－2099）*/
	 	
	    ///@Scheduled(cron="6 * * * * ?")
	    //private void process(){
	    //    System.out.println("this is scheduler task runing  "+(count++));
	    //}

	
}
