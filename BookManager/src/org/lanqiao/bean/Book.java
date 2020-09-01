package org.lanqiao.bean;

/*
 * book类
 * bid,name,author(作者),price(价格),image(图片),
 * content(简介),status(1-正常，2-下架) , counts(下载量) ,created(时间)
 */

public class Book {
	
	private int bid;
	private String name;
	private String author;
	private double price;
	private String image;
	private String content;
	private String status;
	private int counts;
	private String created;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", name=" + name + ", author=" + author + ", price=" + price + ", image=" + image
				+ ", content=" + content + ", status=" + status + ", counts=" + counts + ", created=" + created + "]";
	}
	
}
