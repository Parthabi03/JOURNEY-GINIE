package edu.rims.Journey_Ginie.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "destination")
public class Destination extends Auditable {

    @Id
    @Column(name = "destination_id", nullable = false)
    private String destinationId;

    @Column(name = "destination_name", nullable = false, length = 100)
    private String destinationName;

    @Column(name = "destination_description", columnDefinition = "TEXT")
    private String destinationDescription;

    @Column(name = "country", nullable = false, length = 100)
    private String country;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @OneToMany(mappedBy = "destination")
    private List<Booking> bookings;
}

