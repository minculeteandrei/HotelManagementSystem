package com.example.ehotel.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "rooms")
public class Booking {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(targetEntity = Room.class, mappedBy = "booking",cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Room> rooms;
    private Long code;
    @Transient
    private List<Services> services;

    public Booking(List<Room> rooms, List<Services> services){
        this.rooms = rooms;
        this.code = Long.valueOf(UUID.randomUUID().toString());
        this.services = services;

        for(Room r : this.rooms){
            r.makeUnavailable();
            r.setBooking(this);
        }
    }

    public void addExtras(List<Services> services){
        this.services.addAll(services);
    }
}
