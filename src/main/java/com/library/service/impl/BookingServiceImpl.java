package com.library.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.entity.Booking;
import com.library.repository.BookingRepository;
import com.library.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{
	
	private BookingRepository bookingRepo;

	public BookingServiceImpl(BookingRepository bookingRepo) {
		super();
		this.bookingRepo = bookingRepo;
	}

	@Override
	public Booking saveBooking(Booking booking) {
		return bookingRepo.save(booking);
	}

	@Override
	public List<Booking> getBookingsByUserId(Long userId) {
		return bookingRepo.findAllByUserId(userId);
	}

	@Override
	public void deleteBooking(Long id) {
		bookingRepo.deleteById(id);
	}
	
	
}
