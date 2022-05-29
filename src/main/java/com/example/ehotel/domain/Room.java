package com.example.ehotel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue
    private Long id;
    private int noOfBeds;
    private boolean available;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ToString.Exclude
    private Hotel hotel;

    @ManyToOne(targetEntity = Booking.class)
    @ToString.Exclude
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

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
