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
    @GeneratedValue(strategy = GenerationType.UUID)
    private String destinationId;

    // @ManyToOne
    // @JoinColumn(name = "user_id",referencedColumnName = "user_id", nullable = false)
    // private User user;

    @Column(name = "destination_name", length = 100)
    private String destinationName;

    @Column(name = "destination_description", columnDefinition = "TEXT")
    private String destinationDescription;

    @Column(name = "country",  length = 100)
    private String country;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @OneToMany(mappedBy = "destination")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "destination")
    private List<DestinationPlace> destinationPlaces;  

}

