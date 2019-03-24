package com.fces.domain.dto;

public class ScoreTeacher {
	private String id;
	private String clazzId;
	private String clazzName;
	private String studentId;
	private String studentNum;
	private String studentName;
	private String teacherId;
	private String teacherNum;
	private String teacherName;
	private double score;

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

	public String getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherNum() {
		return teacherNum;
	}

	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "ScoreTeacher{" +
				"id='" + id + '\'' +
				", clazzId='" + clazzId + '\'' +
				", clazzName='" + clazzName + '\'' +
				", studentId='" + studentId + '\'' +
				", studentNum='" + studentNum + '\'' +
				", studentName='" + studentName + '\'' +
				", teacherId='" + teacherId + '\'' +
				", teacherNum='" + teacherNum + '\'' +
				", teacherName='" + teacherName + '\'' +
				", score=" + score +
				'}';
	}
}
