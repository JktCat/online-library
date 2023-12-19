package com.library.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.entity.Book;
import com.library.entity.Comment;
import com.library.entity.User;
import com.library.service.BookService;
import com.library.service.CommentService;

@Controller
public class CommentController {

	private CommentService commentService;
	private BookService bookService;

	public CommentController(CommentService commentService, BookService bookService) {
		super();
		this.commentService = commentService;
		this.bookService = bookService;
	}
	
	@PostMapping("/comments/add")
	public String addComment(@RequestParam("star") int star, @RequestParam("content") String content,
	        @RequestParam("bookId") Long bookId, HttpSession session) {
	  
		User user = (User) session.getAttribute("loggedInUser");
	    Book book = bookService.getBookById(bookId);

	    Comment comment = new Comment();
	    comment.setStar(star);
	    comment.setContent(content);
	    comment.setUser(user);
	    comment.setBook(book);

	    commentService.saveComment(comment);
	    
	    return "redirect:/books/" + bookId;
	}
	
	@GetMapping("/comments/delete/{bookId}/{commentId}")
	public String deleteComment(@PathVariable Long bookId,
			@PathVariable Long commentId) {
		System.out.println(commentId);
	    commentService.deleteComment(commentId);
	    return "redirect:/books/" + bookId;
	}


}
