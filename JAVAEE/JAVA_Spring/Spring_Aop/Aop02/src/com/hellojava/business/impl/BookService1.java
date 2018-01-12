package com.hellojava.business.impl;

import com.hellojava.business.IBookService;

public class BookService1 implements IBookService{

	@Override
	public void save() {
		System.out.println("BookService1 save()");
		
	}

	@Override
	public void delete() {
		System.out.println("BookService1 delete()");
		
	}

}
