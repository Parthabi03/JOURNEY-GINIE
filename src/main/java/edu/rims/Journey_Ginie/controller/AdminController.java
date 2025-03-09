package edu.rims.Journey_Ginie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import edu.rims.Journey_Ginie.entity.Destination;
import edu.rims.Journey_Ginie.repository.DestinationRepository;

import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class AdminController {
   @Autowired
   private DestinationRepository destinationRepository;
    
    @GetMapping("/admin/adhome")
    public String adminAdhome(){
        return "admin/adhome";
    }

    @GetMapping("/admin/addest")
    String adminAddest(Model model){
      List<Destination> destinations = destinationRepository.findAll();
      model.addAttribute("destinations",destinations);
       return"admin/addest";
    }

    @PostMapping("/admin/addest")
    public String destinationAdd(@ModelAttribute Destination destination){
      destinationRepository.save(destination);
      return "redirect:/admin/addest";
    }
    
    
    

    @GetMapping("/admin/adbook")
    String customerAdbook(){
       return"admin/adbook";
    }

    @GetMapping("/admin/adtour")
    String customerAdtour(){
       return"admin/adtour";
    }

    @GetMapping("/admin/adcust")
    String customerAdcust(){
       return"admin/adcust";
    }

    @GetMapping("/admin/logout")
    String customerLogout(){
       return"admin/logout";
    }

    @GetMapping("/admin/addestplace")
    String customerDestplace() {
       return "admin/addestplace";
    }
}