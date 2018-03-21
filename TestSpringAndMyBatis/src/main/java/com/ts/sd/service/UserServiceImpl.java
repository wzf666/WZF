package com.ts.sd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ts.sd.dao.UserMapper;
import com.ts.sd.pojo.User;

@Service("uService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}


	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public User getUserById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int addUser(User user) {
		int count = userMapper.insert(user);
		int c = 1/0;
		return count;
	}

}
