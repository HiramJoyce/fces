package com.fces.service;

import com.fces.domain.Student;
import com.fces.domain.dto.ScoreStudent;
import com.fces.domain.dto.ScoreTeacher;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {
	Student login(String studentNum, String password);

	List<Student> getAllStudent();

	Student updateStudent(Student student);

	Student createStudent(Student student);

	void deleteStudent(String id);

    Student getStudentById(String id);

    List<Student> batchImport(MultipartFile excelFile);

    List<ScoreTeacher> getStudentsByClazzId(String clazzId);

	void removeStudentFromClazz(String studentId, String clazzId);

	Student isStudentInClazz(String studentId, String clazzId);

	void addStudentToClazz(String studentId, String clazzId);

	ScoreTeacher getTeacherScore(String teacherId, String studentId, String clazzId);

	int addTeacherScore(String teacherId, String studentId, String clazzId, String score);

	List<ScoreStudent> getStudentsByClazzId2(String clazzId);

	List<ScoreStudent> getScoredStudentsByClazzId(String fromStudentId, String clazzId);

	ScoreStudent getStudentScore(String fromStudentId, String toStudentId, String clazzId);

	int addStudentScore(String fromStudentId, String toStudentId, String clazzId, String score);

	List<ScoreStudent> getToStudentScore(String toStudentId, String clazzId);
}
