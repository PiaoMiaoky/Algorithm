package com.hellojava.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
//当前是一个切面
@Aspect
//表明是一个组件
@Component("logAspect")
public class LogAspect implements IAspect{
	
	//定义连接点
	@Pointcut("execution(* com.hellojava.business.IBookService.save(..))")
	public void afterPoint() {}
	
	@Pointcut("execution(* com.hellojava.business.IBookService.save(..))")
	public void beforePonit() {}
	
	@Pointcut("execution(* com.hellojava.business.IBookService.*(..))")
	public void aroundPoint() {}

	
	//通知后置通知(切入在afterPoint定义结点)
	@After("afterPoint()")
	public void after() {
		System.out.println("afterPoint");
		
	}

	@Before("beforePonit()")
	public void before() {
		System.out.println("beforePoint");
		
	}

	@Around("aroundPoint()")
	public Object around(ProceedingJoinPoint joinPoint) {
		System.out.println("around before");
		Object obj= null;
		try {
			obj = joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("around after");
		return obj;
	}
	
}
