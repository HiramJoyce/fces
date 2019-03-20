package com.fces.dao;

import org.springframework.stereotype.Repository;

import com.fces.domain.Admin;

@Repository
public interface AdminDao {

	Admin selectAdminByUserName(String userName);
}
