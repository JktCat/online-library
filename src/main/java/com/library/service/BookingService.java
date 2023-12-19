package com.library.service;

import java.util.List;

import com.library.entity.Booking;

public interface BookingService {

	Booking saveBooking(Booking booking);
	
	List<Booking> getBookingsByUserId(Long userId);
	
	void deleteBooking(Long id);
}
