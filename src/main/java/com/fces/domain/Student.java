package com.fces.domain;

public class Student {
	private String id;
	private String studentNum;
	private String realName;
	private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentNum=" + studentNum + ", realName=" + realName + ", password=" + password
				+ "]";
	}
}
