package com.hellojava.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public interface ILog {
	public void after();
	public void before();
	public Object around(ProceedingJoinPoint joinPoint);
}
