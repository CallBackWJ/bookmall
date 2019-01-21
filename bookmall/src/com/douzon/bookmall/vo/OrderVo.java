package com.douzon.bookmall.vo;

public class OrderVo {
	
private long no;
private long money;
private String address;
private MemberVo member;

public long getNo() {
	return no;
}
public void setNo(long no) {
	this.no = no;
}
public long getMoney() {
	return money;
}
public void setMoney(long money) {
	this.money = money;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public MemberVo getMember() {
	return member;
}
public void setMember(MemberVo member) {
	this.member = member;
}
@Override
public String toString() {
	return "주문정보 [주문번호=" + no + ", 결제금액=" + money + ", 배송지=" + address + "," + member + "]";
}






}
