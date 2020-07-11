package com.neo.query;

public class IpBrokenLineQuery {
	
	private int mycount;
	private String year;
	private String month;
	private String day;
	private String time;
	
	
	
	
	@Override
	public String toString() {
		return "IpBrokenLineQuery [mycount=" + mycount + ", year=" + year + ", month=" + month + ", day=" + day
				+ ", time=" + time + "]";
	}
	public int getMycount() {
		return mycount;
	}
	public String getYear() {
		return year;
	}
	public String getMonth() {
		return month;
	}
	public String getDay() {
		return day;
	}
	public String getTime() {
		return time;
	}
	public void setMycount(int mycount) {
		this.mycount = mycount;
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
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
