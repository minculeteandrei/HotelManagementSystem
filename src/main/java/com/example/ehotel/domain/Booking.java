package com.example.ehotel.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(targetEntity = Room.class, mappedBy = "booking", fetch = FetchType.EAGER)
    private List<Room> rooms;
    private Long code;
    private List<String> services;

    public Booking(List<Room> rooms){
        this.rooms = rooms;
        this.code = Long.valueOf(UUID.randomUUID().toString());

        for(Room r : this.rooms){
            r.makeUnavailable();
        }
    }

    public void addExtras(List<String> services){
        this.services.addAll(services);
    }
}
