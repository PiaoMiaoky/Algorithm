package com.hellojava.entity;

import java.io.Serializable;

public class Book implements Serializable{
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private double bookPrice;
	private String bookInfo;
	private String Bookdata;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(String bookInfo) {
		this.bookInfo = bookInfo;
	}
	public String getBookdata() {
		return Bookdata;
	}
	public void setBookdata(String bookdata) {
		Bookdata = bookdata;
	}
	public Book() {
		
	}
	public Book(int bookId,String bookName,String bookAuthor,double bookPrice,String bookInfo) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookInfo = bookInfo;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookPrice="
				+ bookPrice + ", bookInfo=" + bookInfo + "]";
	}
	
}
