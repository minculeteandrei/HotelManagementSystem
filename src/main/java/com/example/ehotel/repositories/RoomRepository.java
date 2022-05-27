package com.example.ehotel.repositories;

import com.example.ehotel.domain.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long> {
    List<Room> findAll();
}
