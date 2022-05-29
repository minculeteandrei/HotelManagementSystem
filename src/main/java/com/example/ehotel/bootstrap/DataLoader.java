package com.example.ehotel.bootstrap;

import com.example.ehotel.domain.Hotel;
import com.example.ehotel.domain.Room;
import com.example.ehotel.services.HotelService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final HotelService hotelService;

    public DataLoader(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    @Override
    public void run(String... args) throws Exception {
        List<Room> roomList1 = getRoomList();
        List<Room> roomList2 = getRoomList();

        Hotel h1 = new Hotel("hotel1");
        Hotel h2 = new Hotel("hotel2");

        for(Room r : roomList1)
            h1.addRoom(r);

        for(Room r : roomList2)
            h2.addRoom(r);

        hotelService.save(h1);
        hotelService.save(h2);

        List<Hotel> hotels = hotelService.findAll();
        hotels.forEach(System.out :: println);

    }

    private List<Room> getRoomList() {
        List<Room> roomList2 = List.of(
                new Room(1, true),
                new Room(2, true),
                new Room(2, true),
                new Room(2, true),
                new Room(2, true),
                new Room(2, true),
                new Room(2, true),
                new Room(1, true),
                new Room(1, true),
                new Room(1, false)
        );
        return roomList2;
    }
}
