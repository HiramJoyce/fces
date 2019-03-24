package com.fces.domain.dto;

public class ScoreStudent {
	private String id;
	private String clazzId;
	private String clazzName;
	private String fromStudentId;
	private String fromStudentNum;
	private String fromStudentName;
	private String toStudentId;
	private String toStudentNum;
	private String toStudentName;
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
	public String getFromStudentId() {
		return fromStudentId;
	}
	public void setFromStudentId(String fromStudentId) {
		this.fromStudentId = fromStudentId;
	}
	public String getFromStudentName() {
		return fromStudentName;
	}
	public void setFromStudentName(String fromStudentName) {
		this.fromStudentName = fromStudentName;
	}
	public String getToStudentId() {
		return toStudentId;
	}
	public void setToStudentId(String toStudentId) {
		this.toStudentId = toStudentId;
	}
	public String getToStudentName() {
		return toStudentName;
	}
	public void setToStudentName(String toStudentName) {
		this.toStudentName = toStudentName;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	public String getFromStudentNum() {
		return fromStudentNum;
	}

	public void setFromStudentNum(String fromStudentNum) {
		this.fromStudentNum = fromStudentNum;
	}

	public String getToStudentNum() {
		return toStudentNum;
	}

	public void setToStudentNum(String toStudentNum) {
		this.toStudentNum = toStudentNum;
	}

	@Override
	public String toString() {
		return "ScoreStudent{" +
				"id='" + id + '\'' +
				", clazzId='" + clazzId + '\'' +
				", clazzName='" + clazzName + '\'' +
				", fromStudentId='" + fromStudentId + '\'' +
				", fromStudentNum='" + fromStudentNum + '\'' +
				", fromStudentName='" + fromStudentName + '\'' +
				", toStudentId='" + toStudentId + '\'' +
				", toStudentNum='" + toStudentNum + '\'' +
				", toStudentName='" + toStudentName + '\'' +
				", score=" + score +
				'}';
	}
}
