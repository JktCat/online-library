package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{
	
	@Query(value = "SELECT * FROM bookings WHERE user_id = :userId", nativeQuery = true)
	List<Booking> findAllByUserId(@Param("userId") Long userId);
}
