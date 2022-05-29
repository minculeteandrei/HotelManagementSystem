package com.example.ehotel.repositories;

import com.example.ehotel.domain.Hotel;
import com.example.ehotel.domain.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HotelRepository extends CrudRepository<Hotel, Long> {
    Hotel findHotelById(Long id);
    List<Hotel> findAll();
}