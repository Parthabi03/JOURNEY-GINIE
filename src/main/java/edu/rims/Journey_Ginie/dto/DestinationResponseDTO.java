package edu.rims.Journey_Ginie.dto;

import edu.rims.Journey_Ginie.constant.DestinationStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinationResponseDTO {
    private String destinationId;
    private String destinationName;
    private String description;
    private String country;
    private String city;
    private String imageUrl;
    private Double price;
    private DestinationStatus destinationStatus; 
}
