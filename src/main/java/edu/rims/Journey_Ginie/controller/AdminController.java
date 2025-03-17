package edu.rims.Journey_Ginie.controller;

import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rims.Journey_Ginie.dto.TourRequestDto;
import edu.rims.Journey_Ginie.entity.Destination;
import edu.rims.Journey_Ginie.repository.DestinationRepository;
import edu.rims.Journey_Ginie.repository.AttractionRepository;
import edu.rims.Journey_Ginie.entity.Tour;
import edu.rims.Journey_Ginie.repository.TourRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
   @Autowired
   private DestinationRepository destinationRepository;

   @Autowired
   private TourRepository tourRepository;

   @Autowired
   private AttractionRepository attractionRepository;

   @GetMapping("/dashboard")
   public String showDashboard() {
      return "admin/dashboard";
   }

   @GetMapping("/destinations")
   public String showDestinations(Model model) {
      List<Destination> destinations = destinationRepository.findAll();
      model.addAttribute("destinations", destinations);
      return "admin/destinations";
   }

   @GetMapping("/bookings")
   public String showBookings() {
      return "admin/bookings";
   }

   @GetMapping("/attractions")
   public String showAttractions(Model model) {
      model.addAttribute("attractions", attractionRepository.findAll());
      return "admin/attractions";
   }

   @GetMapping("/tours")
   public String showTours(Model model) {
      List<Tour> tours = tourRepository.findAll();
      List<Destination> destinations = destinationRepository.findAll();

      model.addAttribute("tours", tours);
      model.addAttribute("destinations", destinations);

      return "admin/tours";
   }

   @PostMapping("/tours/add")
   public String addTour(@ModelAttribute TourRequestDto dto) throws Exception {
      Tour tour = new Tour();
      tour.setTitle(dto.title());
      tour.setDescription(dto.description());
      tour.setPrice(dto.price());
      dto.destination().forEach(destinationId -> {
         var destination = destinationRepository.findById(destinationId).orElseThrow();
         tour.addDestination(destination);
      });

      var file = dto.image();
      if (!file.isEmpty()) {
         String originalFilename = file.getOriginalFilename();
         String extName = originalFilename.substring(originalFilename.lastIndexOf("."));

         String fileName = "upload_images/" + UUID.randomUUID().toString() + extName;

         FileOutputStream fileOutputStream = new FileOutputStream(fileName);
         fileOutputStream.write(file.getBytes());
         fileOutputStream.close();
         tour.setImageUrl(fileName);
      }

      tourRepository.save(tour);
      return "redirect:/admin/tours";
   }

   @GetMapping("/customers")
   public String showCustomers() {
      return "admin/customers";
   }
}
