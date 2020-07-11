package com.neo.domain;

public class PermissionsTable {

	private int    		id 				 	;
	private String 		p_controller        ;//控制器controller
	private String 		p_method          	;//控制器对应的方法
	private String 		p_desc          	;//权限的描述
	private int 		g_id           		;//组的id
	public int getId() {
		return id;
	}
	public String getP_controller() {
		return p_controller;
	}
	public String getP_method() {
		return p_method;
	}
	public String getP_desc() {
		return p_desc;
	}
	public int getG_id() {
		return g_id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setP_controller(String p_controller) {
		this.p_controller = p_controller;
	}
	public void setP_method(String p_method) {
		this.p_method = p_method;
	}
	public void setP_desc(String p_desc) {
		this.p_desc = p_desc;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	
	
	
	
}
