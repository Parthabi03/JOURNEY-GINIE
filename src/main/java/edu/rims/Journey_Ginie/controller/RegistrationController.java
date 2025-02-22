package edu.rims.Journey_Ginie.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import edu.rims.Journey_Ginie.entity.User;
import edu.rims.Journey_Ginie.repository.UserRepository;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

     @GetMapping("/registrationplp")
     String fragmentRegistrationplp() {
        return "registrationplp";
    }



@PostMapping("/registrationplp")
public String registrationPlp(@ModelAttribute User user){
    userRepository.save(user);
    return "redirect:/login";
}
}


