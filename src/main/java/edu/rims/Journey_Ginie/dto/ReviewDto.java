package edu.rims.Journey_Ginie.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class ReviewDto {

    @NotBlank(message = "Tour ID is required")
    private String tourId;

    @Min(1) @Max(5)
    private Integer rating;

    private String reviewComment;
}
