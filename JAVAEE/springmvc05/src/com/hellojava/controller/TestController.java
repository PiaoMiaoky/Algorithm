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
	//@ModelAttribute 标识的方法会在当前的Controller中定义的所有处理请求的方法执行之前执行
		//返回值会自动添加到当前的请求的Model中 前台的spring form标签可以和后台的数据进行绑定
		//ModelAttribute 中的对象和参数对象进行合并
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
		Book b = new Book(10,"springMVC","张三",33.44,"测试");
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
