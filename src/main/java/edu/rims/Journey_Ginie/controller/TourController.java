package edu.rims.Journey_Ginie.controller;

import java.io.FileInputStream;
// import java.io.FileOutputStream;
import java.io.IOException;
// import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.multipart.MultipartFile;

import edu.rims.Journey_Ginie.entity.Tour;
import edu.rims.Journey_Ginie.repository.TourRepository;

@Controller
public class TourController {
   @Autowired
   private TourRepository tourRepository;

   @GetMapping("/customer/tour/tour")
   String getTourByTourId(@RequestParam("tour") String tourId, Model model) {
      Tour tour = tourRepository.findById(tourId).orElseThrow();
      model.addAttribute("tour", tour);
      return "customer/tour";
   }

   
   @GetMapping("/customer/pdp2")
   String pdp() {
      return "/customer/pdp2";
  }

      @GetMapping("/tour/images/{id}")
      @ResponseBody
      public byte[] getTourImage(@PathVariable String id) throws IOException{
      Tour tour = tourRepository.findById(id).orElseThrow();
         String imageName = tour.getImageUrl();
         if (imageName== null || imageName.startsWith("http")) {
            return null;
            
         }
         FileInputStream fileInputStream = new FileInputStream(imageName);
          return fileInputStream.readAllBytes();
      }
}
