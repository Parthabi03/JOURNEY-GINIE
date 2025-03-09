package edu.rims.Journey_Ginie.controller;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.rims.Journey_Ginie.entity.Destination;
import edu.rims.Journey_Ginie.entity.DestinationPlace;
import edu.rims.Journey_Ginie.repository.DestinationRepository;
import edu.rims.Journey_Ginie.repository.Destination_placeRepository;

@Controller
public class DestinationController {
   @Autowired
   private DestinationRepository destinationRepository;
   @Autowired
   private Destination_placeRepository destination_placeRepository;

   // @GetMapping("/customer/destination")
   // String customerDestination() {
   //    return "/customer/destination";
   // }

   @GetMapping("/customer/destination/destination")
   String getDestinationByDestinationId(@RequestParam("destination") String destinationId, Model model) {
      Destination destination = destinationRepository.findById(destinationId).orElseThrow();
      model.addAttribute("destination", destination);
      return "/customer/destination";
   }

   @GetMapping("/customer/pdp")
   String customerPdp() {
      return "/customer/pdp";
   }

   @GetMapping("/customer/destination_place/pdp")
   String getDestinationByplaceId(@RequestParam("destination_place") String placeId, Model model) {
      DestinationPlace destination_place = destination_placeRepository.findById(placeId).orElseThrow();
      model.addAttribute("destination_place", destination_place);
      return "customer/pdp";
   }

}
