package com.example.ehotel.services;

import com.example.ehotel.domain.Hotel;
import com.example.ehotel.domain.Room;
import com.example.ehotel.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServiceImp implements HotelService{
    private final HotelRepository hotelRepository;

    public HotelServiceImp(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void save(Hotel h) {
        hotelRepository.save(h);
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Room> findAvailable(Hotel h) {
        List<Room> aux = new ArrayList<>();
        for(Room r : h.getRooms()){
            if(r.isAvailable())
                aux.add(r);
        }
        return aux;
    }

    @Override
    public List<Room> findUnavailable(Hotel h) {
        List<Room> aux = new ArrayList<>();
        for(Room r : h.getRooms()){
            if(!r.isAvailable())
                aux.add(r);
        }
        return aux;
    }

    @Override
    public Hotel findHotelById(Long id) {
        return this.hotelRepository.findHotelById(id);
    }
}
