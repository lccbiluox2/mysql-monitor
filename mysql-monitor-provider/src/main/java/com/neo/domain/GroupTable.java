package com.neo.domain;

public class GroupTable {
		
	private int    		id 				 	;
	private String 		g_name           	;//组的名字
	private String 		g_desc          	;//组的描述
	private int 		user_id           	;//用户的id
	public int getId() {
		return id;
	}
	public String getG_name() {
		return g_name;
	}
	public String getG_desc() {
		return g_desc;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public void setG_desc(String g_desc) {
		this.g_desc = g_desc;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	
}
