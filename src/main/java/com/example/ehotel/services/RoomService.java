package com.example.ehotel.services;

import com.example.ehotel.domain.Room;

import java.util.List;

public interface RoomService {
    void save(Room r);
    void saveAll(List<Room> rooms);
    List<Room> findAll();
    List<Room> findAvailable();
    List<Room> findUnavailable();
}
