package com.fces.dao;

import com.fces.domain.Clazz;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClazzDao {

	List<Clazz> selectAllClazz();

	Clazz selectClazzById(String id);

	int updateClazz(Clazz clazz);

	int insertClazz(Clazz clazz);

	void deleteClazzById(String id);

    List<Clazz> selectClazzesByTeacherId(String teacherId);

    List<Clazz> selectClazzesByStudentId(String studentId);
}
