package edu.rims.Journey_Ginie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.rims.Journey_Ginie.entity.Booking;
import edu.rims.Journey_Ginie.repository.BookingRepository;

@Controller
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/customer/booking")
    String fragmentBooking(){
        return"customer/booking";
    }

    @PostMapping("/customer/booking")
public String booking(@ModelAttribute Booking booking){
   bookingRepository.save(booking);
    return "redirect:/customer/success";
}

    @GetMapping("/customer/success")
    String fragmentSuccess(){
        return"customer/success";
    }

    // @GetMapping("/customer/itineraries")
    // String fragmentItineraries(){
    //     return"customer/itineraries";
    // }

    @GetMapping("/customer/inspiration")
    String fragmentInspiration(){
        return"customer/inspiration";
    }

    @GetMapping("/customer/payment")
    String fragmentPayment(){
        return"customer/payment";
    }



}