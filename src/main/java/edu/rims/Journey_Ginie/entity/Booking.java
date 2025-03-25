package edu.rims.Journey_Ginie.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "booking")
@Getter
@Setter
public class Booking extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "booking_id", length = 255, nullable = false, updatable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = true)
    private Destination destination;

    @ManyToOne
    @JoinColumn(name = "tour_id", nullable = true)
    private Tour tour;

    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "status", length = 50)
    private String status; 

    // Constructor
    public Booking() {
        this.bookingDate = LocalDate.now(); // Default to current date
    }

    // Helper methods to set booking for a destination or tour
    public void bookDestination(Destination destination) {
        this.destination = destination;
        this.tour = null;
        this.totalPrice = destination.getPrice();
    }

    public void bookTour(Tour tour) {
        this.tour = tour;
        this.destination = null;
        this.totalPrice = tour.getPrice();
    }
}
