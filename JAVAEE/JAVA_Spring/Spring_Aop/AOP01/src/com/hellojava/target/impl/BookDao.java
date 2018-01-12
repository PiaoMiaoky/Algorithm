package com.hellojava.target.impl;

import com.hellojava.target.IBookDao;

public class BookDao implements IBookDao{

	@Override
	public void save() {
		System.out.println("BookDao save()");
		
	}

}
