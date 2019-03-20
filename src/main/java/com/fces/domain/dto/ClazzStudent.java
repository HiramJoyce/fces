package com.fces.domain.dto;

public class ClazzStudent {
	private String id;
	private String clazzId;
	private String clazzName;
	private String studentId;
	private String studentName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClazzId() {
		return clazzId;
	}
	public void setClazzId(String clazzId) {
		this.clazzId = clazzId;
	}
	public String getClazzName() {
		return clazzName;
	}
	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	@Override
	public String toString() {
		return "ClazzStudent [id=" + id + ", clazzId=" + clazzId + ", clazzName=" + clazzName + ", studentId="
				+ studentId + ", studentName=" + studentName + "]";
	}
}
