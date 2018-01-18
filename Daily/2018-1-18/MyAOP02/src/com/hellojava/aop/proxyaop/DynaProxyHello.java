package com.hellojava.aop.proxyaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Proxy;

import com.hellojava.aop.Aspect.Level;
import com.hellojava.aop.Aspect.Logger;

public class DynaProxyHello implements InvocationHandler, org.springframework.cglib.proxy.InvocationHandler{
	private Object delegate;
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws Throwable {
		Object result = null;
		try {
		 //执行方法之前记录日志 
		Logger.logging(Level.DEBUGE,method.getName()+"Method end");
		 //JVM通过这条语句执行原来的方法(反射机制)
		result = method.invoke(this.delegate,args);
		//执行原来的方法之后记录日志
		Logger.logging(Level.INFO,method.getName()+"Method Start!");
		}catch(Exception e){
			e.printStackTrace();
		}
		//返回方法返回值给调用者
		return result;
	}
	public Object bind(Object delegate) {
		this.delegate = delegate;
		return Proxy.newProxyInstance( 
		       this.delegate.getClass().getClassLoader(), this.delegate 
		       .getClass().getInterfaces(), this); 
	}		

}
