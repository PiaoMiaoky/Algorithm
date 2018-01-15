package com.hellojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hellojava.business.IBookService;
import com.hellojava.entity.Book;

@Controller
public class TestController {
	@Autowired
	private IBookService bookService;
	//@ModelAttribute ��ʶ�ķ������ڵ�ǰ��Controller�ж�������д�������ķ���ִ��֮ǰִ��
		//����ֵ���Զ���ӵ���ǰ�������Model�� ǰ̨��spring form��ǩ���Ժͺ�̨�����ݽ��а�
		//ModelAttribute �еĶ���Ͳ���������кϲ�
//		@ModelAttribute
//		public void init() {
//			System.out.println("init");
//		}
	
	@ModelAttribute
	public Book initBook(@RequestParam(name = "bookId",required=false)Integer id) {
		Book b = null;
		if(id ==null) {
			b = new Book();
		}else {
			b = bookService.loadById(id);
		}
		return b;
	}
	
	@RequestMapping("/saveView")
	public String saveView(Model model) {
		Book b = new Book(10,"springMVC","����",33.44,"����");
		model.addAttribute("book",b);
		return "save";
	}
	@RequestMapping("/updateView")
	public String updateView() {
		return "update";
	}
	
	@RequestMapping("/testHandler")
	public String testHandler() {
		System.out.println("testHandler");
		return "index";
	}
	
	@RequestMapping("/testHandler1")
	public String testHandler1() {
		System.out.println("testHandler1");
		return "index";
	}
	
	@RequestMapping("/saveHandler")
	public String saveHandler(Book b) {
		System.out.println(b);
		return "index";
	}
	
	@RequestMapping("/updateHandler")
	public String updateHandler(@ModelAttribute("book")Book b) {
		System.out.println(b);
		return "index";
	}
}
