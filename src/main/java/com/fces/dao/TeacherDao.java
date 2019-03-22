package com.fces.dao;

import com.fces.domain.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao {

	Teacher selectTeacherByTeacherNum(String teacherNum);

	List<Teacher> selectAllTeacher();
}
