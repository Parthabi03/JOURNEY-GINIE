package edu.rims.Journey_Ginie.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
// import java.util.Locale.Destination;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.rims.Journey_Ginie.entity.Destination;
import edu.rims.Journey_Ginie.repository.DestinationRepository;

@Controller
public class DestinationController {
   @Autowired
   private DestinationRepository destinationRepository;

   @GetMapping("/customer/destination")
   String getDestinationByDestinationId(Model model) {
      model.addAttribute("destinations", destinationRepository.findAll());
      return "customer/destination";
   }

   @PostMapping("/admin/destinations")
   public String destinationAdd(@ModelAttribute Destination destination,
         @RequestParam("destinationImageFile") MultipartFile file, @RequestParam String destImage) throws IOException {
      String destinationId = destination.getDestinationId();
      destination.setDestinationId(destinationId == null || destinationId.isEmpty() ? null : destinationId);
      if (!file.isEmpty()) {
         String originalFilename = file.getOriginalFilename();
         String extName = originalFilename.substring(originalFilename.lastIndexOf("."));

         String fileName = "upload_images/" + UUID.randomUUID().toString() + extName;

         FileOutputStream fileOutputStream = new FileOutputStream(fileName);
         fileOutputStream.write(file.getBytes());
         fileOutputStream.close();
         destination.setImageUrl(fileName);
      }else if(!destImage.isEmpty()){
         destination.setImageUrl(destImage);
      }
      destinationRepository.save(destination);
      return "redirect:/admin/destinations";
   }

   @GetMapping("/destination/images/{destinationId}")
   @ResponseBody
   public byte[] getDestinationImage(@PathVariable String destinationId) throws IOException {
      Destination destination = destinationRepository.findById(destinationId).orElseThrow();
      String imageName = destination.getImageUrl();
      if (imageName == null || imageName.startsWith("http")) {
         return null;

      }
      FileInputStream fileInputStream = new FileInputStream(imageName);
      return fileInputStream.readAllBytes();
   }

   @GetMapping("/destination/search")
   String searchDestination(@RequestParam("search") String destinationName, Model model) {
      List<Destination> destinations = destinationRepository.findByDestinationNameContainingIgnoreCase(destinationName);
      model.addAttribute("destinations", destinations);
      return "customer/destination";
   }

   @GetMapping("/customer/destination/pdp")
   String getDestinationBydestinationId(@RequestParam("destination") String destinationId, Model model) {
      Destination destination = destinationRepository.findById(destinationId).orElseThrow();
      model.addAttribute("destination", destination);
      return "customer/pdp";
   }

}
