package edu.rims.Journey_Ginie.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class BookingDto {

    @NotBlank(message = "Tour ID is required")
    private String tourId;

    @NotBlank(message = "Destination ID is required")
    private String destinationId;

    @Min(value = 1, message = "At least 1 guest required")
    private Integer numberOfGuests;
}
