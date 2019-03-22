package com.fces.service.impl;

import com.fces.dao.ClazzDao;
import com.fces.domain.Clazz;
import com.fces.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

	@Autowired
	private ClazzDao clazzDao;
	
	public List<Clazz> getAllClazz() {
		return clazzDao.selectAllClazz();
	}

	@Override
	public Clazz getClazzById(String id) {
		return clazzDao.selectClazzById(id);
	}

	@Override
	public Clazz updateClazz(Clazz clazz) {
		return clazzDao.updateClazz(clazz) > 0 ? clazz : null;
	}

	@Override
	public Clazz createClazz(Clazz clazz) {
		return clazzDao.insertClazz(clazz) > 0 ? clazz : null;
	}

}
