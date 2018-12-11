package com.joey.springboot.controller;

import java.util.List;
import java.util.Map;

import com.joey.springboot.model.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joey.springboot.model.Book;
import com.joey.springboot.service.BookService;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")

public class HelloController {
	
    @Autowired
	private BookService bookService;

    @Autowired
    private Config config;

	@Value("${spring.mvc.view.prefix}")
    private String port;

	@RequestMapping("/index")
	public String index(){
		return "js/index";
	}


	@RequestMapping("/say")
	@ResponseBody
	public List<Book> hello() {
		List<Book> books = bookService.getAllBooks();
		return books;
	}

	@RequestMapping("/get")
	@ResponseBody
	public String get() {
		Map book = bookService.getBooksById(1);
		book.get("id");
		book.get("price");
		String title = (String)book.get("title");
		return title;
	}

	//获取配置文件参数
	@ResponseBody
	@RequestMapping("/weixin")
	public String weixin(){
	    System.out.print(config.getPort());
		return port;
	}
}
