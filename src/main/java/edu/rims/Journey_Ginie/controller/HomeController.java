package edu.rims.Journey_Ginie.controller;

import edu.rims.Journey_Ginie.service.DestinationService;
import edu.rims.Journey_Ginie.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final TourService tourService;
    private final DestinationService destinationService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tours", tourService.getAllTours());
        model.addAttribute("destinations", destinationService.getAllDestinations());
        return "index";
    }
}
