package edu.rims.Journey_Ginie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "plp_tours")
public class Packages {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "package_id", length = 255, nullable = false, updatable = false)
    private String id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "title", length = 200, nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @ManyToOne
    private Tour tour;
}