package com.example.demo.service;

import com.example.demo.feign.MovieClient;
import com.example.demo.dto.Movie;
import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    MovieClient movieClient;

    @CircuitBreaker(name = "movieService", fallbackMethod = "bookingFallback")
    public Booking createBooking(Booking booking) {
        Movie movie = movieClient.getMovieById(booking.getMovieId());
        double totalAmount = movie.getPrice() * booking.getTickets();
        booking.setTotalAmount(totalAmount);
        return bookingRepository.save(booking);
    }

    public Booking bookingFallback(Booking booking, Exception e) {
        booking.setBookingId(-1);
        booking.setTotalAmount(0);
        return booking;
    }

    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }
}