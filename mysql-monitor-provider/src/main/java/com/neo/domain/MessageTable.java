package com.neo.domain;

public class MessageTable  extends  DomainBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int 		id 				; //
	private String 	 	m_content 		; //留言内容
	private int 	 	user_id 		; //留言人ID
	private String 	 	user_name 		; //留言人name
	private String 	 	create_time 	; //发表时间
	private int 	 	id_check		; //审核 1 审核通过 2未审核 3审核未通过
	
	
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getM_content() {
		return m_content;
	}
	public void setM_content(String m_content) {
		this.m_content = m_content;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public int getId_check() {
		return id_check;
	}
	public void setId_check(int id_check) {
		this.id_check = id_check;
	}
	
	

}
