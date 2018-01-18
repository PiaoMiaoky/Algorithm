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
		 //ִ�з���֮ǰ��¼��־ 
		Logger.logging(Level.DEBUGE,method.getName()+"Method end");
		 //JVMͨ���������ִ��ԭ���ķ���(�������)
		result = method.invoke(this.delegate,args);
		//ִ��ԭ���ķ���֮���¼��־
		Logger.logging(Level.INFO,method.getName()+"Method Start!");
		}catch(Exception e){
			e.printStackTrace();
		}
		//���ط�������ֵ��������
		return result;
	}
	public Object bind(Object delegate) {
		this.delegate = delegate;
		return Proxy.newProxyInstance( 
		       this.delegate.getClass().getClassLoader(), this.delegate 
		       .getClass().getInterfaces(), this); 
	}		

}
