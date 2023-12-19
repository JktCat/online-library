package com.library.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.library.entity.Book;
import com.library.entity.User;
import com.library.service.BookService;
import com.library.service.CommentService;

@Controller
public class BookController {

	private BookService bookService;
	private CommentService commentService;
	
	public BookController(BookService bookService, CommentService commentService) {
		super();
		this.bookService = bookService;
		this.commentService = commentService;
	}
	
	
	
	@GetMapping("/books")
    public String getBooks(HttpSession session, Model model) {
		model.addAttribute("books", bookService.getAllBooks());
    	User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            String role = loggedInUser.getRole();
            model.addAttribute("role_loggedIn", role);
        }
        return "books";
    }
	
	@GetMapping("/books/{id}")
	public String viewBook(@PathVariable Long id, Model model) {
		model.addAttribute("book", bookService.getBookById(id));
		model.addAttribute("comments", commentService.getCommentsByBookId(id));
		return "book_view";
	}
	
	@GetMapping("/books/edit/{id}")
	public String editBookForm(@PathVariable Long id, Model model) {
		model.addAttribute("id", id);
		Book book = new Book();
		if(id > 0) model.addAttribute("book", bookService.getBookById(id));
		else model.addAttribute("book",book);
		return "book_detail";
	}
	
	
	@PostMapping("/books/edit")
	public String addBook(@ModelAttribute("book") Book book, @RequestParam MultipartFile img, Model model) {
		Book existingBook = bookService.getBookByTitleAndAuthor(book.getTitle(), book.getAuthor());
		if (existingBook != null) {
            model.addAttribute("error3", true);
            book.setImage("/images/" + img.getOriginalFilename());
            model.addAttribute("book", book);
            model.addAttribute("id", -1);
            return "book_detail";
        } else {
        	book.setPrice(69000);
    		book.setImage("/images/" + img.getOriginalFilename());
    		bookService.saveBook(book);
    		return "redirect:/books";
        }
	}
	
	
	@PutMapping("books/edit/{id}")
	public String updateBook(@ModelAttribute("book") Book book, @RequestParam MultipartFile img) {
		System.out.println("Put");
		Book b = bookService.getBookById(book.getId());
		book.setPrice(b.getPrice());
		book.setQuantitySold(b.getQuantitySold());
		System.out.println("1" + img.getOriginalFilename());
		String image = "";
		if(img.getOriginalFilename().equals("")) {
			image = b.getImage();
			System.out.println("2" + image);
			book.setImage(image);
		}else {
			book.setImage("/images/" + img.getOriginalFilename());
		}
		
		bookService.saveBook(book);
		return "redirect:/books";
	}
	
	@GetMapping("books/delete/{id}")
	public String deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}
	
	@GetMapping("/home/search")
	public String searchBook(@RequestParam("txt") String txt, Model model) {
		List<Book> books = bookService.searchBook(txt);
		for(Book x : books) {
			System.out.println(x.getTitle());
		}
		model.addAttribute("books", books);
		
		return "home_page";
	}
	
	
}

