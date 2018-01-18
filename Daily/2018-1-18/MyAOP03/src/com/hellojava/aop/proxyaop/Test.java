package com.hellojava.aop.proxyaop;

public class Test {
	public static void main(String[] args) {
		IHello hello = (IHello) new DynaProxyHello().bind(new Hello(),new LoggerOperation());
		hello.sayHello("ÀîËÄ");
		hello.sayGoogBye("ê°Èý");
	}
}
