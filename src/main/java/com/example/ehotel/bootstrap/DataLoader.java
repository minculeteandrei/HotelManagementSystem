package com.example.ehotel.bootstrap;

import com.example.ehotel.domain.Room;
import com.example.ehotel.services.RoomService;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

public class DataLoader implements CommandLineRunner {
    private final RoomService roomService;

    public DataLoader(RoomService roomService) {
        this.roomService = roomService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Room> roomList = List.of(
                new Room(1, true),
                new Room(2, true),
                new Room(2, true),
                new Room(2, true),
                new Room(2, true),
                new Room(2, true),
                new Room(2, true),
                new Room(1, true),
                new Room(1, true),
                new Room(1, true)
        );
        roomService.saveAll(roomList);
    }
}
