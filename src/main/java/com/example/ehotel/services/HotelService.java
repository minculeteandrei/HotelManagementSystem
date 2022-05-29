package com.example.ehotel.services;

import com.example.ehotel.domain.Hotel;
import com.example.ehotel.domain.Room;

import java.util.List;

public interface HotelService {
    void save(Hotel h);
    List<Hotel> findAll();
    List<Room> findAvailable(Hotel h);
    List<Room> findUnavailable(Hotel h);
    Hotel findHotelById(Long id);
}
