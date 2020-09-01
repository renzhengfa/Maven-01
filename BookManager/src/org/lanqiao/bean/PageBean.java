package org.lanqiao.bean;

import java.util.ArrayList;
import java.util.List;

/*
 * 分页时每一页的类
 * pagebean
	当前页索引(currentPageIndex),
	当前页数据条数(currentPageProducts),
	总数据条数(totalProducts),
	总页数(pages),
	当前页所有图书信息(courentProductsInfo) .
 */

public class PageBean {
	
	private int currentPageIndex;
	private int currentPageProducts;
	private int totalProducts;
	private int pages;
	private List<Book> list = new ArrayList<Book>();
	
	public int getCurrentPageIndex() {
		return currentPageIndex;
	}
	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}
	public int getCurrentPageProducts() {
		return currentPageProducts;
	}
	public void setCurrentPageProducts(int currentPageProducts) {
		this.currentPageProducts = currentPageProducts;
	}
	public int getTotalProducts() {
		return totalProducts;
	}
	public void setTotalProducts(int totalProducts) {
		this.totalProducts = totalProducts;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public List<Book> getList() {
		return list;
	}
	public void setList(List<Book> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "PageBean [currentPageIndex=" + currentPageIndex + ", currentPageProducts=" + currentPageProducts
				+ ", totalProducts=" + totalProducts + ", pages=" + pages + ", list=" + list + "]";
	}
	
}
