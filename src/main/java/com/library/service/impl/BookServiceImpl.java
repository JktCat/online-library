package com.library.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import com.library.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	private BookRepository bookRepo;
	
	public BookServiceImpl(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	@Override
	public Book getBookById(Long id) {
		return bookRepo.findById(id).get();
	}

	@Override
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}

	@Override
	public Book getBookByTitleAndAuthor(String title, String author) {
		return bookRepo.getBookByTitleAndAuthor(title, author);
	}

	@Override
	public List<Book> searchBook(String txt) {
		return bookRepo.searchBook(txt);
	}


	

}
