package com.fces.dao;

import com.fces.domain.Student;
import com.fces.domain.dto.ScoreStudent;
import com.fces.domain.dto.ScoreTeacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {

	Student selectStudentByStudentNum(String studentNum);

	List<Student> selectAllStudent();

	int updateStudent(Student student);

	int insertStudent(Student student);

	int deleteStudentById(String id);

	Student selectStudentById(String id);

    List<ScoreTeacher> selectStudentsByClazzId(String clazzId);

	int deleteStudentFromClazz(@Param("studentId") String studentId, @Param("clazzId") String clazzId);

	Student selectStudentFromClazz(@Param("studentId") String studentId, @Param("clazzId") String clazzId);

	int insertStudentToClazz(@Param("studentId") String studentId, @Param("clazzId") String clazzId);

	ScoreTeacher selectTeacherScore(@Param("teacherId") String teacherId, @Param("studentId") String studentId,  @Param("clazzId") String clazzId);

	int insertTeacherScore(@Param("teacherId") String teacherId, @Param("studentId") String studentId, @Param("clazzId") String clazzId, @Param("score") String score);

	List<ScoreStudent> selectStudentsByClazzId2(String clazzId);

	List<ScoreStudent> selectBeScoredStudentsByClazzIdAndFromStudentId(@Param("clazzId") String clazzId, @Param("fromStudentId") String fromStudentId);

    ScoreStudent selectStudentScore(@Param("fromStudentId") String fromStudentId, @Param("toStudentId") String toStudentId, @Param("clazzId") String clazzId);

    int insertStudentScore(@Param("fromStudentId") String fromStudentId, @Param("toStudentId") String toStudentId, @Param("clazzId") String clazzId, @Param("score") String score);

    List<ScoreStudent> selectToStudentScore(@Param("toStudentId") String toStudentId, @Param("clazzId") String clazzId);
}
