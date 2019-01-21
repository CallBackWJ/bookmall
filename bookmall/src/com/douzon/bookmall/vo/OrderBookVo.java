package com.douzon.bookmall.vo;

public class OrderBookVo {

	private OrderVo order;
	private BookVo book;
	private long count;
	
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public OrderVo getOrder() {
		return order;
	}
	public void setOrder(OrderVo order) {
		this.order = order;
	}
	public BookVo getBook() {
		return book;
	}
	public void setBook(BookVo book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "주문도서목록 [ 수량=" + count + "," + book + "]";
	}
	
	
	

}
