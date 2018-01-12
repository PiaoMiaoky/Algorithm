package com.hellojava.business.impl;

import org.springframework.stereotype.Service;

import com.hellojava.business.IBookService;

@Service("bookService")
public class BookService implements IBookService{

	@Override
	public void save() {
		System.out.println("bookService save");
		
	}

	@Override
	public void delete() {
		System.out.println("bookService delete");
		
	}
	
}
