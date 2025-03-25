package edu.rims.Journey_Ginie.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.rims.Journey_Ginie.constant.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tour")
@Getter
@Setter
public class Tour extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tour_id", length = 255, nullable = false, updatable = false)
    private String id;

    @Column(name = "title", length = 200, nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "trip_duration", nullable = false)
    private int tripDuration;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    // Many-to-Many relationship between Tour and Destination
    @ManyToMany
    @JoinTable(name = "tour_destinations", joinColumns = @JoinColumn(name = "tour_id"), inverseJoinColumns = @JoinColumn(name = "destination_id"))
    private List<Destination> destinations;

    @OneToMany(mappedBy = "tour")
    private List<Booking> bookings;

    @OneToMany
    private List<Packages> packages;

    // Add a destination to the tour
    public void addDestination(Destination destination) {
        if (destinations == null)
            destinations = new ArrayList<>();
        destinations.add(destination);
    }

    public void addPackage(Packages package1) {
        if (packages == null){
            packages = new ArrayList<>();
        }
        packages.add(package1);
    }

    // Remove a destination from the tour
    public void removeDestination(Destination destination) {
        destinations.remove(destination);
    }
}
