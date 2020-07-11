package com.neo.domain;

public class NewsTable extends  DomainBase{
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4449181095467336734L;
	
	private String	id 				;  // 
	private String	title			;  // 新闻标题
	private String	zaiyao			;  // 新闻摘要
	private String	time			;  // 新闻发生的时间
	private String	create_time		;  // 新闻发布的时间
	private String	content			;  // 新闻的内容
	private String	tag				;  // 新闻的标签
	private int	user_id			;  // 发布人的id
	private String	user_name		;  // 发布人的名称
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getZaiyao() {
		return zaiyao;
	}
	public void setZaiyao(String zaiyao) {
		this.zaiyao = zaiyao;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
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
	
	
	
}
