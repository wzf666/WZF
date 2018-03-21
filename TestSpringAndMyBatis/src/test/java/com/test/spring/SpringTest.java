package com.test.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ts.sd.aop.User;
import com.ts.sd.aop.UserService;

public class SpringTest {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserService us = (UserService) ac.getBean("userService");
		
		us.addUser(new User());
	}
}
