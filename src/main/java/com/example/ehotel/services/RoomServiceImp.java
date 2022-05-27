package com.example.ehotel.services;

import com.example.ehotel.domain.Room;
import com.example.ehotel.repositories.RoomRepository;

import java.util.ArrayList;
import java.util.List;

public class RoomServiceImp implements RoomService{
    private final RoomRepository roomRepository;

    public RoomServiceImp(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void save(Room r) {
        roomRepository.save(r);
    }

    @Override
    public void saveAll(List<Room> rooms) {
        roomRepository.saveAll(rooms);
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public List<Room> findAvailable() {
        List<Room> aux = new ArrayList<>();
        for(Room r : roomRepository.findAll()){
            if(r.isAvailable())
                aux.add(r);
        }
        return aux;
    }

    @Override
    public List<Room> findUnavailable() {
        List<Room> aux = new ArrayList<>();
        for(Room r : roomRepository.findAll()){
            if(!r.isAvailable())
                aux.add(r);
        }
        return aux;
    }
}
