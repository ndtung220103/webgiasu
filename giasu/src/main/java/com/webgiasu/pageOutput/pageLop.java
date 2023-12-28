package com.webgiasu.pageOutput;

import java.util.List;

public class pageLop<T> {
	
	private int page; // trang hiện tại
	private int totalPage; // số trang
	private List<T> ds;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getDs() {
		return ds;
	}
	public void setDs(List<T> ds) {
		this.ds = ds;
	}
	
}
