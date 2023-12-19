package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
	@Query(value = "SELECT * FROM books WHERE title = :title && author = :author", nativeQuery = true)
	Book getBookByTitleAndAuthor(@Param("title") String title, @Param("author") String author); 
	
	@Query(value = "SELECT * FROM books WHERE title LIKE %:txt%", nativeQuery = true)
	List<Book> searchBook(@Param("txt") String txt); 
}
