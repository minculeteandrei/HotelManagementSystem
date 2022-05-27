package com.example.ehotel.repositories;

import com.example.ehotel.domain.Booking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findAll();
}
