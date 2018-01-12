package com.hellojava.aspect.impl;

import org.aspectj.lang.ProceedingJoinPoint;

import com.hellojava.aspect.ILog;

public class Log implements ILog{

	@Override
	public void after() {
		System.out.println("after");
		
	}

	@Override
	public void before() {
		System.out.println("before");
		
	}

	@Override
	public Object around(ProceedingJoinPoint joinPoint) {
		System.out.println("around before");
		Object obj  = null;
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
