package edu.rims.Journey_Ginie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {

    @GetMapping("/customer/booking")
    String fragmentBooking(){
        return"customer/booking";
    }

    @GetMapping("/customer/success")
    String fragmentSuccess(){
        return"customer/success";
    }
}