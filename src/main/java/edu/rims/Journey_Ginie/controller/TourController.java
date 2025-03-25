package edu.rims.Journey_Ginie.controller;

import edu.rims.Journey_Ginie.dto.TourRequestDto;
import java.io.FileInputStream;
// import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
// import java.util.UUID;
// import java.nio.file.Files;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.multipart.MultipartFile;

import edu.rims.Journey_Ginie.entity.Tour;
import edu.rims.Journey_Ginie.repository.TourRepository;
import edu.rims.Journey_Ginie.entity.Packages;
import edu.rims.Journey_Ginie.repository.PackagesRepository;

@Controller
public class TourController {
   @Autowired
   private TourRepository tourRepository;

   @Autowired
   private PackagesRepository packagesRepository;

   @GetMapping("/customer/tour")
   String getTourByTourId(Model model, @RequestParam("tour") String id) {
      Tour tour = tourRepository.findById(id).orElseThrow();  
      model.addAttribute("tour", tour);
      System.out.println(tour.getPackages().size());
      return "customer/tour";
   }

   
   @GetMapping("/customer/packages/pdp2")
   String getPackageById(@RequestParam("package") String packageId, Model model) {
     Packages packages = packagesRepository.findById(packageId).orElseThrow();
      model.addAttribute("package", packages);
      return "customer/pdp2";
   }

      @GetMapping("/tours/images/{tourId}")
      @ResponseBody
      public byte[] getTourImage(@PathVariable String tourId) throws IOException{
      Tour tour = tourRepository.findById(tourId).orElseThrow();
         String imageName = tour.getImageUrl();
         if (imageName== null || imageName.startsWith("http")) {
            return null;
            
 }

         FileInputStream fileInputStream = new FileInputStream(imageName);
          return fileInputStream.readAllBytes();
      }
   
}


