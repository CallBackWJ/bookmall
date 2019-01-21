package com.douzon.bookmall.vo;

public class CategoryVo {
	private long no;
	private String classification;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	@Override
	public String toString() {
		return "카테고리 [분류번호=" + no + ", 종류=" + classification + "]";
	}

}
