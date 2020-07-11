package com.neo.domain;

public class IpcountBean extends  DomainBase{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 		id;
	private String	 	ip;
	private String 		url;
	private String 		time;
	private String 		year;
	private String 		month;
	private String 		day;
	
	
	
	
	public String getYear() {
		return year;
	}
	public String getMonth() {
		return month;
	}
	public String getDay() {
		return day;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public String getIp() {
		return ip;
	}
	public String getUrl() {
		return url;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public void setUrl(String url) {
		this.url = url;
	}


	
	
}
