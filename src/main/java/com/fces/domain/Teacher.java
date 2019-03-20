package com.fces.domain;

public class Teacher {
	private String id;
	private String teacherNum;
	private String realName;
	private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTeacherNum() {
		return teacherNum;
	}
	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
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
		return "Teacher [id=" + id + ", teacherNum=" + teacherNum + ", realName=" + realName + ", password="
				+ password + "]";
	}
}
