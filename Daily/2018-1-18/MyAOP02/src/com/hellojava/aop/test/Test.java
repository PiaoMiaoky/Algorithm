package com.hellojava.aop.test;

import com.hellojava.aop.proxyaop.DynaProxyHello;
import com.hellojava.aop.proxyaop.Hello;
import com.hellojava.aop.proxyaop.IHello;

public class Test {
	public static void main(String[] args) {
		IHello hello = (IHello)new DynaProxyHello().bind(new Hello());
		hello.sayHello("ÀîËÄ");
		hello.sayGoogBye("ê°Èý");
	}
}
