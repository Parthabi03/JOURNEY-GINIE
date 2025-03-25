package edu.rims.Journey_Ginie.entity;

import java.util.ArrayList;
import java.util.List;

import edu.rims.Journey_Ginie.constant.DestinationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "destination")
public class Destination extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "destination_id", nullable = false, updatable = false)
    private String destinationId;

    @Column(name = "destination_name", length = 100, nullable = false)
    private String destinationName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "country", length = 100, nullable = false)
    private String country;

    @Column(name = "city", length = 100, nullable = false)
    private String city;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @Column(name = "price", nullable = false)
    private Double price;

    @Enumerated(EnumType.STRING)
    private DestinationStatus destinationStatus = DestinationStatus.AVAILABLE;

    @OneToMany(mappedBy = "destination")
    private List<Booking> bookings = new ArrayList<>();

    @ManyToMany(mappedBy = "destinations")
    private List<Tour> tours;

    public void addBooking(Booking booking) {
        bookings.add(booking);
        booking.setDestination(this);
    }
    @ManyToMany(mappedBy= "destinations")
    private List<Widget> destinations;
    
}
