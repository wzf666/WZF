package com.test.spring;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ts.sd.pojo.User;
import com.ts.sd.service.UserService;

public class TestSpringAndMyBatis {
	private Logger log = LoggerFactory.getLogger(TestSpringAndMyBatis.class);
		@Test
		public void test() {
			ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserService us = (UserService) ac.getBean("uService");
			User user = us.getUserById(1l);
			log.info("userName====={}",user.getUsername());
	}
		@Test
		public void test1() {
			ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserService us = (UserService) ac.getBean("uService");
			User user = new User();
			user.setUsername("ÕÅÈý555");
			user.setUsercode("zhangsan555");
			int count  = us.addUser(user);
			log.info("count ====,{}",user.getUsername());
		}
	

}
