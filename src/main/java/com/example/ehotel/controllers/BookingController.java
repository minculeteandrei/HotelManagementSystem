package com.example.ehotel.controllers;

import com.example.ehotel.domain.Booking;
import com.example.ehotel.domain.BookingForm;
import com.example.ehotel.domain.Hotel;
import com.example.ehotel.services.BookingService;
import com.example.ehotel.services.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/booking")
public class BookingController {
    private final HotelService hotelService;
    private final BookingService bookingService;

    public BookingController(HotelService hotelService, BookingService bookingService) {
        this.hotelService = hotelService;
        this.bookingService = bookingService;
    }

    @GetMapping("/create")
    public String getCreateBooking(@RequestParam Long hid, Model m){
        Hotel h = hotelService.findHotelById(hid);
        m.addAttribute("booking", new BookingForm());
        m.addAttribute("rooms", hotelService.findAvailable(h));
        return "new_booking";
    }

    @PostMapping("/create")
    public String makeReservation(Booking booking){
        bookingService.save(booking);
        return "redirect:/";
    }
}
