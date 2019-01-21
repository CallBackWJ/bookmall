package com.douzon.bookmall.vo;

public class BookVo{
	private long no;
	private String name;
	private long price;
	private CategoryVo category;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public CategoryVo getCategory() {
		return category;
	}
	public void setCategory(CategoryVo category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "도서정보 [도서번호=" + no + ", 제목=" + name + ", 가격=" + price + "," + category + "]";
	}
	
	
}
