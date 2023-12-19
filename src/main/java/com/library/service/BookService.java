package com.library.service;

import java.util.List;

import com.library.entity.Book;

public interface BookService {
	
	List<Book> getAllBooks();
	
	Book getBookById(Long id);
	
	Book updateBook(Book book);
	
	Book saveBook(Book book);

	void deleteBook(Long id);
	
	Book getBookByTitleAndAuthor(String title, String author);
	
	List<Book> searchBook(String txt);
}
