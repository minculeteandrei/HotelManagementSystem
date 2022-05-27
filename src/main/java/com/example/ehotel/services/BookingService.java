package com.example.ehotel.services;

import com.example.ehotel.domain.Booking;

import java.util.List;

public interface BookingService {
    void save(Booking b);
    List<Booking> findAll();
}
