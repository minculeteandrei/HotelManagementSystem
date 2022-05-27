package com.example.ehotel.services;

import com.example.ehotel.domain.Booking;
import com.example.ehotel.repositories.BookingRepository;

import java.util.List;

public class BookingServiceImp implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImp(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void save(Booking b) {
        bookingRepository.save(b);
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }
}
