package com.hellojava.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hellojava.config.SpringConfiguration;
import com.hellojava.target.IBookDao;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		IBookDao bookDao  =(IBookDao)context.getBean("proxy");
		bookDao.save();
	}
}
