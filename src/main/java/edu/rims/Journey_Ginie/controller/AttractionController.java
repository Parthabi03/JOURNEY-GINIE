package edu.rims.Journey_Ginie.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import edu.rims.Journey_Ginie.entity.Attraction;
import edu.rims.Journey_Ginie.repository.AttractionRepository;

@Controller
public class AttractionController {

    @Autowired
    private AttractionRepository attractionRepository;

    @GetMapping("/customer/attraction")
    public String getAttractionByAttractionId(@RequestParam("attraction") String attractionId, Model model) {
        List<Attraction> attractions = attractionRepository.findAll();
        model.addAttribute("attractions", attractions);
        Attraction attraction = attractionRepository.findById(attractionId).orElseThrow();
        model.addAttribute("attraction", attraction);
        return "customer/attraction";
    }

    @PostMapping("/admin/attractions")
    public String attractionAdd(@ModelAttribute Attraction attraction,
            @RequestParam("attractionImageFile") MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf("."));

            // Save the file in a directory (ensure the directory exists)
            String uploadDir = "upload_images/";
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String fileName = uploadDir + UUID.randomUUID().toString() + extName;

            try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
                fileOutputStream.write(file.getBytes());
            }

            attraction.setImageUrl(fileName);
        }
        

        attractionRepository.save(attraction);
        return "redirect:/admin/attractions";
    }

    @GetMapping("/attraction/images/{attractionId}")
    @ResponseBody
    public byte[] getAttractionImage(@PathVariable String attractionId) throws IOException {
        Attraction attraction = attractionRepository.findById(attractionId).orElseThrow();
        String imageName = attraction.getImageUrl();

        if (imageName == null || imageName.startsWith("http")) {
            return null;
        }

        File file = new File(imageName);
        if (!file.exists()) {
            return null;
        }

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            return fileInputStream.readAllBytes();
        }
    }
}
