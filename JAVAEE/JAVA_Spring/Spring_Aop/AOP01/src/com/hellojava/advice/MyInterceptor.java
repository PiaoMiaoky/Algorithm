package com.hellojava.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.hellojava.aspect.LogAspect;

public class MyInterceptor implements MethodInterceptor{
	public LogAspect aspect;
	public LogAspect getAspect() {
		return aspect;
	}
	public void setAspect(LogAspect aspect) {
		this.aspect = aspect;
	}
	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		aspect.log();
		Object obj=method.proceed();
		aspect.log();
		return obj;
	}
}
