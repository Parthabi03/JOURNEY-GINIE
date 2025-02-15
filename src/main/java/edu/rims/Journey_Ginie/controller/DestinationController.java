package edu.rims.Journey_Ginie.controller;

import java.util.List;

import edu.rims.Journey_Ginie.entity.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rims.Journey_Ginie.repository.DestinationRepository;

@Controller
@RequestMapping("/destination")
public class DestinationController {
    @Autowired
    private DestinationRepository destinationRepository;
    @GetMapping("/destination")
    public String destination(Model model){
        List<Destination> destinations = destinationRepository.findAll();
        model.addAttribute("destinations", destinations);
        return "destination";
    }
}
