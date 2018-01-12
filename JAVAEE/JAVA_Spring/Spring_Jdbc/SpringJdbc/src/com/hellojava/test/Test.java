package com.hellojava.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hellojava.business.IUserService;
import com.hellojava.spring.config.SpringConfiguration;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		IUserService userService = context.getBean(IUserService.class);
		userService.loadAll().forEach(System.out::println);
	}
}
