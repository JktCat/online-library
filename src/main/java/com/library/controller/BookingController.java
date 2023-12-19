package com.library.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.entity.Booking;
import com.library.entity.User;
import com.library.service.BookService;
import com.library.service.BookingService;

@Controller
public class BookingController {

	private BookingService bookingService;
	private BookService bookService;

	public BookingController(BookingService bookingService, BookService bookService) {
		super();
		this.bookingService = bookingService;
		this.bookService = bookService;
	}
	
//	@GetMapping("/books/bookings")
//	public String viewBooking(Model model) {
//		return "booking";
//	}
//	
	@PostMapping("/bookings")
	public String createBooking(@ModelAttribute("booking") Booking booking,
			@RequestParam("bookId") Long bookId, HttpSession session) {
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		booking.setUserId(loggedInUser.getId());
		booking.setBookId(bookId);
	    bookingService.saveBooking(booking);
	    
	    return "redirect:/bookings";
	}
	
	@GetMapping("/bookings")
	public String getBookings(Model model, HttpSession session) {
		User loggedInUser = (User) session.getAttribute("loggedInUser");
	    List<Booking> bookings = bookingService.getBookingsByUserId(loggedInUser.getId());
	    for(Booking x : bookings) {
	    	System.out.println(x.getId());
	    	x.setBook(bookService.getBookById(x.getBookId()));
	    }
	    model.addAttribute("bookings", bookings);
	    return "booking";
	}
	@GetMapping("bookings/delete/{id}")
	public String deleteBooking(@PathVariable Long id) {
		bookingService.deleteBooking(id);
		return "redirect:/bookings";
	}

	
	
}
