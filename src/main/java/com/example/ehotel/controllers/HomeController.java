package com.example.ehotel.controllers;

import com.example.ehotel.services.BookingService;
import com.example.ehotel.services.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final BookingService bookingService;
    private final HotelService hotelService;

    public HomeController(BookingService bookingService, HotelService hotelService) {
        this.bookingService = bookingService;
        this.hotelService = hotelService;
    }

    @GetMapping
    public String getHomeAll(Model m){
        m.addAttribute("hotels", hotelService.findAll());
        return "home";
    }

}
