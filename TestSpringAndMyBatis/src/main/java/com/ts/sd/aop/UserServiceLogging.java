package com.ts.sd.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("usl")
@Aspect
public class UserServiceLogging {
	private Logger log = LoggerFactory.getLogger(UserServiceLogging.class);
	
	@Pointcut("execution(* com.ts.sd.aop..*.*(..))")
	public void pc() {
		
	}
	@Before("pc()")
	public void before(JoinPoint jp) {
		log.info("运行{}程序的方法{},方法入参{}",jp.getTarget(),jp.getSignature().getName(),Arrays.toString(jp.getArgs()));
	}
	
	@AfterReturning(value="pc()",returning="result")
	public void afterReturning(JoinPoint jp,Object result) {
		log.info("运行{}程序的方法{},方法的返回值{}",jp.getTarget(),jp.getSignature().getName(),result);
	}
	
	@AfterThrowing(value="pc()",throwing="e")
	public void afterThrowing(JoinPoint jp,Throwable e) {
		log.info("运行{}程序的方法{},方法抛出异常信息{}",jp.getTarget(),jp.getSignature().getName(),e.getMessage());		
	}
	
	@After("pc()")
	public void after(JoinPoint jp) {
		log.info("运行{}程序的方法{},方法执行结束！",jp.getTarget(),jp.getSignature().getName());
	}
	
	@Around("pc()")
	public void around(ProceedingJoinPoint jp) {
		try {
			log.info("运行{}程序的方法{},方法入参{}",jp.getTarget(),jp.getSignature().getName(),Arrays.toString(jp.getArgs()));
			Object proceed = jp.proceed();
			log.info("运行{}程序的方法{},方法的返回值{}",jp.getTarget(),jp.getSignature().getName(),proceed);
		} catch (Throwable e) {
			log.info("运行{}程序的方法{},方法抛出异常信息{}",jp.getTarget(),jp.getSignature().getName(),e.getMessage());					
		}finally {
			log.info("运行{}程序的方法{},方法执行结束！",jp.getTarget(),jp.getSignature().getName());
		}
	}
}
