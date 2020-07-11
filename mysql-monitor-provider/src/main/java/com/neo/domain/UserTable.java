package com.neo.domain;

public class UserTable extends  DomainBase{
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4449181095467336734L;
	
	private int    		id 				     ;
	private String 		user_name            ;
	private String 		user_passwd          ;
	private String 		user_email           ;
	private String 		user_phone           ;
	private String 		group_code           ;
	public int getId() {
		return id;
	}
	public String getUser_name() {
		return user_name;
	}
	public String getUser_passwd() {
		return user_passwd;
	}
	public String getUser_email() {
		return user_email;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setUser_passwd(String user_passwd) {
		this.user_passwd = user_passwd;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	
	
	public String getGroup_code() {
		return group_code;
	}
	public void setGroup_code(String group_code) {
		this.group_code = group_code;
	}
	@Override
	public String toString() {
		return "UserTable [id=" + id + ", user_name=" + user_name + ", user_passwd=" + user_passwd + ", user_email="
				+ user_email + ", user_phone=" + user_phone + ", group_code=" + group_code + "]";
	}
	
	
	
	
	
	
}
