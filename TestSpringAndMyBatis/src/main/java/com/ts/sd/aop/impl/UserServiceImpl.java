package com.ts.sd.aop.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ts.sd.aop.User;
import com.ts.sd.aop.UserDao;
import com.ts.sd.aop.UserService;
@Repository("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao ud;
	
	
	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	@Override
	public void addUser(User user) {
		ud.addUser(user);
	}

}
