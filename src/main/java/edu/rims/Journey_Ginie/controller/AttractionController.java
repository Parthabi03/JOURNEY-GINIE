package edu.rims.Journey_Ginie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AttractionController {

    @GetMapping("/attraction")
    String fragmentAttraction(){
        return"/attraction";
    }
}
