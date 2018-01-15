package com.hellojava.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hellojava.business.IBookService;
import com.hellojava.entity.Book;

@Service("bookService")
public class BookService implements IBookService{
	private static List<Book> bookList;
	static {
		bookList = new ArrayList<>();
		for(int i=0;i<10;i++) {
			Book b = new Book(i+1,"JAVA权威指南","石颢颢",44.22+i,"测试数据");
			bookList.add(b);
		}
	}
	
	@Override
	public List<Book> loadAll() {
		// TODO Auto-generated method stub
		return bookList;
	}

	@Override
	public Book loadById(int id) {
		Book b = null;
		for (Book book : bookList) {
			if(book.getBookId() ==id) {
				b = book;
				break;
			}
		}
		return b;
	}
	
}
