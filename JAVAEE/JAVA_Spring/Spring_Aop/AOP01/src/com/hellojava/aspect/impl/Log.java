package com.hellojava.aspect.impl;

import com.hellojava.aspect.LogAspect;

public class Log implements LogAspect{

	@Override
	public void log() {
		System.out.println("log");
		
	}

}
