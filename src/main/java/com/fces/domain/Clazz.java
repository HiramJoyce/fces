package com.fces.domain;

import java.util.Date;

public class Clazz {
	private String id;
	private String clazzName;
	private String teacherId;
	private String teacherName;
	private Date startTime;
	private Date endTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClazzName() {
		return clazzName;
	}
	public void setClassName(String clazzName) {
		this.clazzName = clazzName;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "Clazz [id=" + id + ", clazzName=" + clazzName + ", teacherId=" + teacherId + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
}
