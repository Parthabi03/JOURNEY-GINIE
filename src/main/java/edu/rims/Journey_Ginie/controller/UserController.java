package edu.rims.Journey_Ginie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class UserController {
    @GetMapping({"/home","/"})
    String home(){
        return "customer/home";
    }
}
