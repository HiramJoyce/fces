package com.fces.service;

import com.fces.domain.Admin;

public interface AdminService {
	Admin login(String userName, String password);
}
