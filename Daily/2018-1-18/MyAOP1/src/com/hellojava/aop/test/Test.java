package com.hellojava.aop.test;

import com.hellojava.aop.businsess.IHello;
import com.hellojava.aop.businsess.impl.Hello;
import com.hellojava.aop.businsess.impl.HelloProxy;

public class Test {
	public static void main(String[] args) {
		IHello hello = new HelloProxy(new Hello());
		hello.sayHello("Doublej");
	}
}
