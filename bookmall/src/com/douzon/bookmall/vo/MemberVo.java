package com.douzon.bookmall.vo;

public class MemberVo {
	private long no;
	private String name;
	private String phone;
	private String email;
	private String password;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "사용자정보 [사용자번호=" + no + ", 이름=" + name + ", 전화번호=" + phone + ", email=" + email + ", password="
				+ password + "]";
	}
	
}
