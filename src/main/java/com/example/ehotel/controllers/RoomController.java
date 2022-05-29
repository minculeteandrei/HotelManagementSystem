package com.example.ehotel.controllers;

import com.example.ehotel.domain.Hotel;
import com.example.ehotel.services.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final HotelService hotelService;

    public RoomController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/")
    public String getRoomsForHotel(@RequestParam Long hid, Model m){
        Hotel h = hotelService.findHotelById(hid);
        m.addAttribute("rooms", h.getRooms());
        m.addAttribute("hotel", h);
        //System.out.println(h.toString());
        return "rooms";
    }

    @GetMapping("/available")
    public String getAvailableRoomsForHotel(@RequestParam Long hid, Model m){
        Hotel h = hotelService.findHotelById(hid);
        m.addAttribute("rooms", hotelService.findAvailable(h));
        m.addAttribute("hotel", h);
        //System.out.println(h.toString());
        return "rooms";
    }

    @GetMapping("/reserved")
    public String getUnavailableRoomsForHotel(@RequestParam Long hid, Model m){
        Hotel h = hotelService.findHotelById(hid);
        m.addAttribute("rooms", hotelService.findUnavailable(h));
        m.addAttribute("hotel", h);
        //System.out.println(h.toString());
        return "rooms";
    }
}
