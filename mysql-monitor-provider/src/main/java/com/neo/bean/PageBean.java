package com.neo.bean;


import java.util.List;
/*
 * @author   lcc  这个是分页的类    对取出的数据进行分类   并且分装到pageBean中  对类的说明 标明开发该类模块的作者
 * @version  1  对类的说明 标明该类模块的版本
 * @see     对类、属性、方法的说明 参考转向，也就是相关主题
 * @param    对方法的说明 对方法中某参数的说明
 * @return   对方法的说明 对方法返回值的说明
 * @exception  对方法的说明 对方法可能抛出的异常进行说明
 */
public class PageBean {
	
	private int currentPage;
	private int pageSize;
	private int recordCount;
	private List recordList;
	private int pageCount;
	private int beginPageIndex;
	private int endPageIndex;
	
	
	
	
	public PageBean(int currentPage, int pageSize, int recordCount,
			List recordList) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		this.recordList = recordList;
		
		pageCount = recordCount % pageSize == 0 ? recordCount / pageSize : recordCount / pageSize +1;
		if(this.currentPage < 1){
			this.currentPage = 1;
		}
		if(this.currentPage > pageCount){
			this.currentPage = pageCount;
		}
		System.out.println(this.currentPage);
		if(pageCount <= 5){
			beginPageIndex = 1;
			endPageIndex = pageCount;
		}else{
			beginPageIndex = this.currentPage - 2;
			endPageIndex = this.currentPage + 2;
			if(beginPageIndex < 1){
				beginPageIndex = 1;
				endPageIndex = 5;
			}
			if(endPageIndex > pageCount){
				endPageIndex = pageCount;
				beginPageIndex = pageCount - 5 + 1;
			}
		}
		
		
		
	}
	
	/*
	 * @param   无参数 	 	 对方法的说明 对方法中某参数的说明
	 * @return  返回当前是第几页 			 对方法的说明 对方法返回值的说明
	 * @exception  	无异常		 对方法的说明 对方法可能抛出的异常进行说明
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	/*
	 * @param   无参数 	 	 对方法的说明 对方法中某参数的说明
	 * @return  返回数据库里的数据按pageSize分 可以分成多少页 			 对方法的说明 对方法返回值的说明
	 * @exception  	无异常		 对方法的说明 对方法可能抛出的异常进行说明
	 */
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/*
	 * @param   无参数 	 	 对方法的说明 对方法中某参数的说明
	 * @return  返回数据库里的数据总共有多少条数据 			 对方法的说明 对方法返回值的说明
	 * @exception  	无异常		 对方法的说明 对方法可能抛出的异常进行说明
	 */
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	
	/*
	 * @param   无参数 	 	 对方法的说明 对方法中某参数的说明
	 * @return  返回当前页的数据集合 			 对方法的说明 对方法返回值的说明
	 * @exception  	无异常		 对方法的说明 对方法可能抛出的异常进行说明
	 */
	public List getRecordList() {
		return recordList;
	}
	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getBeginPageIndex() {
		return beginPageIndex;
	}
	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}
	public int getEndPageIndex() {
		return endPageIndex;
	}
	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
	
	
	

}
