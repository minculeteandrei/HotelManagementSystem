package com.example.ehotel.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BookingForm {
    private List<Long> roomsIds;
    private List<Services> servicesList;

    public BookingForm(List<Long> roomsIds, List<Services> servicesList) {
        this.roomsIds = roomsIds;
        this.servicesList = servicesList;
    }
}
