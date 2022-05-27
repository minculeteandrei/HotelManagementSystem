package com.example.ehotel.controllers;

import com.example.ehotel.services.BookingService;
import com.example.ehotel.services.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final BookingService bookingService;
    private final RoomService roomService;

    public HomeController(BookingService bookingService, RoomService roomService) {
        this.bookingService = bookingService;
        this.roomService = roomService;
    }

    @GetMapping
    public String getHomeAll(Model m){
        m.addAttribute("rooms", roomService.findAll());
        return "home";
    }
}
