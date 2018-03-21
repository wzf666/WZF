package com.ts.sd.service;

import com.ts.sd.pojo.User;

public interface UserService {
	public User getUserById(Long id);
	
	public int addUser(User user);
}
