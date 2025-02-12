package edu.rims.Journey_Ginie.entity;

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

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "country", nullable = false, length = 100)
    private String country;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "image_url", length = 255)
    private String imageUrl;
}

