package edu.rims.Journey_Ginie.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public record TourRequestDto(
    String title,
    String description,
    Double price,
    MultipartFile image,
    List<String> destination
) {
    
}
