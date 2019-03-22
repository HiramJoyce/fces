package com.fces.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.fces.dao.TeacherDao;
import com.fces.domain.Teacher;
import com.fces.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDao teacherDao;
	
	public Teacher login(String teacherNum, String password) {
		Teacher teacher = teacherDao.selectTeacherByTeacherNum(teacherNum);
		if (teacher != null && StringUtils.equals(teacher.getPassword(), password)) {
			return teacher;
		}
		return null;
	}

	@Override
	public List<Teacher> getAllTeacher() {
		return teacherDao.selectAllTeacher();
	}

}
