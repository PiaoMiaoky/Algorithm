package com.hellojava.aop.businsess.impl;

import com.hellojava.aop.Aspect.Level;
import com.hellojava.aop.Aspect.Logger;
import com.hellojava.aop.businsess.IHello;

public class HelloProxy implements IHello{
	private IHello hello;

	@Override
	public void sayHello(String name) {
		 Logger.logging(Level.DEBUGE, "sayHello method start."); 
		 hello.sayHello("Doublej"); 
	     Logger.logging(Level.INFO, "sayHello method end!"); 
		
		
	}

	public HelloProxy(IHello hello) {
		super();
		this.hello = hello;
	}
	

}
