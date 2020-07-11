package com.neo.bean;

/*
 * 这个类是用来存储 一些web全局变量的
 * 
 */

public   class WebBean {
		
	
	private static  Long webClickCount=0l;//统计网站的点击量

	public static Long getWebClickCount() {
		return webClickCount;
	}

	//这个方法前加入了同步锁   为了防止多人访问的时候 出现修改错误的问题
	public static void setWebClickCount(Long webClickCount) {
		WebBean.webClickCount = webClickCount;
	}

	

	
	
}
