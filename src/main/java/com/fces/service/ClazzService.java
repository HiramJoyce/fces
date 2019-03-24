package com.fces.service;

import com.fces.domain.Clazz;

import java.util.List;

public interface ClazzService {
	List<Clazz> getAllClazz();

	Clazz getClazzById(String id);

	Clazz updateClazz(Clazz clazz);

	Clazz createClazz(Clazz clazz);

    void deleteClazz(String id1);

	List<Clazz> getClazzesByTeacherId(String teacherId);

	List<Clazz> getClazzByStudentId(String studentId);
}
