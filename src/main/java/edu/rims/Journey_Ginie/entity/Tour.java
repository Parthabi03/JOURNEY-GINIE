package edu.rims.Journey_Ginie.entity;


import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tour")
@Getter
@Setter


public class Tour extends Auditable {

    @Id
    @Column(name = "tour_id", length = 255)
    private String tourId;

    @Column(name = "tour_title", length = 200, nullable = false)
    private String tourTitle;

    @Column(name = "tour_description", columnDefinition = "TEXT")
    private String tourDescription;

    @Column(name = "tour_destination", length = 100, nullable = false)
    private String tourDestination;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "tour_availability", nullable = false)
    private Integer tourAvailability;

    @Column(name = "tour_start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date tourStartDate;

    @Column(name = "tour_end_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date tourEndDate;

    @OneToMany(mappedBy = "tour")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "tour")
    private List<Review> reviews;

    @OneToMany(mappedBy = "tour")
    private List<Wishlist> wishlists;
}

