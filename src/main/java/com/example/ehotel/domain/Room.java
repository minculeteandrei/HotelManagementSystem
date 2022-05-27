package com.example.ehotel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor

public class Room {
    @Id
    @GeneratedValue
    private Long id;
    private int noOfBeds;
    public boolean available;

    @ManyToOne(targetEntity = Booking.class)
    private Booking booking;

    public Room(int noOfBeds, boolean available) {
        this.noOfBeds = noOfBeds;
        this.available = available;
    }

    public void makeAvailable(){
        this.available = true;
    }

    public void makeUnavailable(){
        this.available = false;
    }
}
