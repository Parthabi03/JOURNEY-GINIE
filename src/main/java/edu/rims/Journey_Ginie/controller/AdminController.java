package edu.rims.Journey_Ginie.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.HashMap;
// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

// import edu.rims.Journey_Ginie.constant.Status;
import edu.rims.Journey_Ginie.constant.WidgetStatus;
import edu.rims.Journey_Ginie.constant.DestinationStatus;
import edu.rims.Journey_Ginie.dto.TourRequestDto;
import edu.rims.Journey_Ginie.entity.Destination;
import edu.rims.Journey_Ginie.dto.DestinationResponseDTO;
import edu.rims.Journey_Ginie.entity.Packages;
import edu.rims.Journey_Ginie.repository.DestinationRepository;
import edu.rims.Journey_Ginie.repository.AttractionRepository;
import edu.rims.Journey_Ginie.entity.Tour;
import edu.rims.Journey_Ginie.entity.Widget;
import edu.rims.Journey_Ginie.repository.TourRepository;
import edu.rims.Journey_Ginie.repository.WidgetRepository;
import edu.rims.Journey_Ginie.repository.PackagesRepository;
// import edu.rims.Journey_Ginie.entity.Widget;
// import edu.rims.Journey_Ginie.repository.WidgetRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
   @Autowired
   private DestinationRepository destinationRepository;

   @Autowired
   private TourRepository tourRepository;

   @Autowired
   private PackagesRepository packagesRepository;

   @Autowired
   private AttractionRepository attractionRepository;

   @Autowired
   private WidgetRepository widgetRepository;

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

   @GetMapping("/destinations/{destinationId}")
   @ResponseBody
   public DestinationResponseDTO getDestination(@PathVariable String destinationId) {
      Destination destination = destinationRepository.findById(destinationId).orElseThrow();
      DestinationResponseDTO dto = new DestinationResponseDTO();
      dto.setDestinationId(destinationId);
      dto.setDestinationName(destination.getDestinationName());
      dto.setDescription(destination.getDescription());
      dto.setCountry(destination.getCountry());
      dto.setCity(destination.getCity());
      dto.setPrice(destination.getPrice());
      dto.setImageUrl(destination.getImageUrl());
      dto.setDestinationStatus(destination.getDestinationStatus());
      return dto;
   }

   @GetMapping("/destinations/remove")
   public String removeDestination(@RequestParam("id") String destinationId) {
      Destination destination = destinationRepository.findById(destinationId).orElseThrow();
      destination.setDestinationStatus(DestinationStatus.UNAVAILABLE);
      destinationRepository.save(destination);
      return "redirect:/admin/destinations";
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

   @GetMapping("/packages")
   public String showPackages(Model model) {
      model.addAttribute("packages", packagesRepository.findAll());
      model.addAttribute("tours", tourRepository.findAll());
      return "admin/packages";
   }

   @PostMapping("/packages")
   public String packagesAdd(@ModelAttribute Packages packages,
         @RequestParam("packagesImageFile") MultipartFile file) throws IOException {

      
      if (!file.isEmpty()) {
         String originalFilename = file.getOriginalFilename();
         String extName = originalFilename.substring(originalFilename.lastIndexOf("."));

         String fileName = "upload_images/" + UUID.randomUUID().toString() + extName;

         FileOutputStream fileOutputStream = new FileOutputStream(fileName);
         fileOutputStream.write(file.getBytes());
         fileOutputStream.close();
         packages.setImageUrl(fileName);
      }
      Tour tour = packages.getTour();
      tour.addPackage(packages);
      packagesRepository.save(packages);
      tourRepository.save(tour);
      
      return "redirect:/admin/packages";
   }

   @GetMapping("/packages/images/{packageId}")
   @ResponseBody
   public byte[] getPackageImage(@PathVariable String packageId) throws IOException {
      Packages packages = packagesRepository.findById(packageId).orElseThrow();
      String imageName = packages.getImageUrl();
      if (imageName == null || imageName.startsWith("http")) {
         return null;

      }
      FileInputStream fileInputStream = new FileInputStream(imageName);
      return fileInputStream.readAllBytes();
   }

   @GetMapping("/customers")
   public String showCustomers() {
      return "admin/customers";
   }

   @GetMapping("/widget")
   public String getWidgets(Model model) {
      model.addAttribute("widgets", widgetRepository.findAll());
      return "admin/widget";
   }

   @PostMapping("/widget/add")
   public String postMethodName(@RequestParam String widgetName, @RequestParam(required = false) String widgetId,
         @RequestParam Integer sequence) {
      Widget widget;

      if (widgetId != null && !widgetId.isEmpty()) {
         widget = widgetRepository.findById(widgetId).orElse(new Widget());
      } else {
         widget = new Widget();
      }
      // Widget widget = widgetRepository.findById(widgetId).orElse(new Widget());
      // widget.setWidgetId(widgetId);
      widget.setSequence(sequence);
      widget.setWidgetName(widgetName);
      widget.setUpdatedDate(LocalDateTime.now());
      widget.setWidgetStatus(WidgetStatus.AVAILABLE);
      widgetRepository.save(widget);
      return "redirect:/admin/widget";
   }

   @PostMapping("/widget/destination/add")
   public String addDestinationToWidget(@RequestParam MultipartFile file) {

      if (file.isEmpty())
         return "redirect:/admin/widget";

      try {
         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()));
         Map<String, String> details = new HashMap<>();

         // for header
         bufferedReader.readLine();
         String line;

         while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(",");
            processDetails(split[0], split[1]);
         }

      } catch (Exception e) {
         throw new RuntimeException(e);
      }

      return "redirect:/admin/widget";
   }

   @GetMapping("/widget/destinations")
   public String getMethodName(@RequestParam("widgetId") String wigetId, Model model) {
      Widget widget = widgetRepository.findById(wigetId).orElseThrow();
      model.addAttribute("widget", widget);
      return "admin/widget-destination";
   }

   private void processDetails(String widgetId, String destinationId) {
      Destination destination = destinationRepository.findById(destinationId).orElse(null);
      Widget widget = widgetRepository.findById(widgetId).orElse(null);

      if (destination != null && widget != null) {
         if (!widget.getDestinations().contains(destination)) {
            widget.addDestination(destination);
            widgetRepository.save(widget);
         }
      }
   }

   @GetMapping("/widget/destination/remove")
   public String getMethodName(@RequestParam String widgetId, @RequestParam String destinationId) {
      Widget widget = widgetRepository.findById(widgetId).orElseThrow();

      widget.removeDestination(destinationId);

      widgetRepository.save(widget);
      return "redirect:/admin/widget";
   }

   @GetMapping("/widget/remove")
   public String removeWidget(@RequestParam("id") String widgetId) {
      Widget widget = widgetRepository.findById(widgetId).orElseThrow();
      widget.setWidgetStatus(WidgetStatus.UNAVAILABLE);
      widgetRepository.save(widget);
      return "redirect:/admin/widget";
   }
}
