package com.hellojava.aop.businsess.impl;

import com.hellojava.aop.businsess.IHello;

public class Hello implements IHello{

	@Override
	public void sayHello(String name) {
		System.out.println("Hello"+name);
		
	}
	
}
