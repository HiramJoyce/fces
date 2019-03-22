package com.fces.service;

import com.fces.domain.Teacher;

import java.util.List;

public interface TeacherService {
	Teacher login(String teacherNum, String password);

	List<Teacher> getAllTeacher();
}
