package edu.rims.Journey_Ginie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rims.Journey_Ginie.entity.Attraction;
import edu.rims.Journey_Ginie.entity.Destination;
import edu.rims.Journey_Ginie.entity.Tour;
import edu.rims.Journey_Ginie.repository.DestinationRepository;
import edu.rims.Journey_Ginie.repository.TourRepository;
import edu.rims.Journey_Ginie.repository.AttractionRepository;

@Controller
@RequestMapping("/customer")
public class UserController {

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private AttractionRepository attractionRepository;

    @GetMapping("/home")
    String home(Model model) {
        List<Destination> destinations = destinationRepository.findAll();
        List<Tour> tours = tourRepository.findAll();
        List<Attraction> attractions = attractionRepository.findAll();
        model.addAttribute("attractions", attractions);
        model.addAttribute("tours", tours);
        model.addAttribute("destinations", destinations);
        return "customer/home";
    }
}
