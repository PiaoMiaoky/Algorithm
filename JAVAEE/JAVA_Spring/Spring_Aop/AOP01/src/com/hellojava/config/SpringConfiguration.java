package com.hellojava.config;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hellojava.advice.MyInterceptor;
import com.hellojava.aspect.LogAspect;
import com.hellojava.aspect.impl.Log;
import com.hellojava.target.IBookDao;
import com.hellojava.target.impl.BookDao;

@Configuration
public class SpringConfiguration  {
	@Bean(name="bookDao")
	public IBookDao bookDaoInstance() {
		return new BookDao();
	}
	
	@Bean(name="aspect")
	public LogAspect logInstance() {
		return new Log();
	}
	
	@Bean(name="inter",autowire=Autowire.BY_NAME)
	public MyInterceptor InterceptorInstance() {
		MyInterceptor inter = new MyInterceptor();
		return inter;
	}
	
	@Bean(name="proxy")
	public ProxyFactoryBean proxyBean() {
		ProxyFactoryBean factory = new ProxyFactoryBean();
		factory.setTarget(bookDaoInstance());
		factory.setInterceptorNames(new String[] {"inter"});
		factory.setInterfaces(IBookDao.class);
		return factory;
	}
	
	
}
