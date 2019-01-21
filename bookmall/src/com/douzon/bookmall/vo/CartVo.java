package com.douzon.bookmall.vo;

public class CartVo {
	private long count;
	private MemberVo member;
	private BookVo book;
	
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public MemberVo getMember() {
		return member;
	}
	public void setMember(MemberVo member) {
		this.member = member;
	}
	public BookVo getBook() {
		return book;
	}
	public void setBook(BookVo book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "장바구니 [수량=" + count + "," + member + "," + book + "]";
	}
	
}
