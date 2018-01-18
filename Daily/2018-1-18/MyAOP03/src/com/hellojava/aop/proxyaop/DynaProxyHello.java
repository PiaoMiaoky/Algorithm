package com.hellojava.aop.proxyaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Proxy;

public class DynaProxyHello implements InvocationHandler, org.springframework.cglib.proxy.InvocationHandler {
	private Object proxy;
	
	private Object delegate;
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		try {
			//����õ������ߵ�ʵ��
			Class clazz = this.proxy.getClass();
			//����õ������ߵ�Start����
			Method start = clazz.getDeclaredMethod("start",new Class[] {Method.class});
			
			//����ִ��satrt����
			start.invoke(this.proxy, new Object[] {method});
			//ִ��Ҫ��������ԭ������
			result = method.invoke(this.delegate, args);
			//����õ������ߵ�end����
			Method end = clazz.getDeclaredMethod("end", new Class[] {Method.class});
			//����ִ��end����
			end.invoke(this.proxy,new Object[] {method});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Object bind(Object delegate, Object proxy) {
		this.proxy = proxy;
		this.delegate = delegate;
		return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader()
				,this.delegate.getClass().getInterfaces(), this);
	}
	

}
