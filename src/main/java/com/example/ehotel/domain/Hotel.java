package com.example.ehotel.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "rooms")
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Room> rooms = new ArrayList<>();

    public Hotel(String name) {
        this.name = name;
    }

    public void addRoom(Room r){
        this.getRooms().add(r);
        r.setHotel(this);
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
