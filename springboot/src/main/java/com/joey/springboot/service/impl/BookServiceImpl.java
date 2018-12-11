package com.joey.springboot.service.impl;

import java.util.List;
import java.util.Map;

import com.joey.springboot.mapper.BookMapper;
import com.joey.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joey.springboot.model.Book;

@Service("bookService")
public class BookServiceImpl implements BookService {
	@Autowired
    private BookMapper bookMapper;

	public List<Book> getAllBooks() {
		return bookMapper.getAllBooks();
	}
	public Map getBooksById(int id) {
		return bookMapper.getBookById(id);
	}
}
