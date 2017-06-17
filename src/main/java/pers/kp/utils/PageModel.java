package pers.kp.utils;

import java.util.List;

public class PageModel {
	private List result;

	private int pageSize=5;//
	private int totalCount;// 
	private int currentPage = 1;
	private int pageCount;// 
	


	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageCount() {
		return (totalCount-1)/pageSize+1;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List getResult() {
		return result;
	}

	public void setResult(List result) {
		this.result = result;
	}

	

}
