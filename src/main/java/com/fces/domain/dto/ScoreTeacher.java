package com.fces.domain.dto;

public class ScoreTeacher {
	private String id;
	private String clazzId;
	private String clazzName;
	private String studentId;
	private String studentName;
	private String teacherId;
	private String teacherName;
	private double score;
	public String getClazzName() {
		return clazzName;
	}
	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
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
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "ScoreTeacher [id=" + id + ", clazzId=" + clazzId + ", clazzName=" + clazzName + ", studentId="
				+ studentId + ", studentName=" + studentName + ", teacherId=" + teacherId + ", teacherName="
				+ teacherName + ", score=" + score + "]";
	}
	
}
