package edu.rims.Journey_Ginie.entity;

import java.time.LocalDateTime;
import java.util.List;

import edu.rims.Journey_Ginie.constant.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking extends Auditable {

    @Id
    @Column(name = "booking_id", nullable = false)
    private String bookingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id", referencedColumnName = "tour_id", nullable = false)
    private Tour tour;

    @Column(name = "booking_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime bookingDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "booking_status", nullable = false)
    private BookingStatus bookingStatus = BookingStatus.PENDING;

    @Column(name = "number_of_guests", nullable = false)
    private int numberOfGuests;

    @Column(name = "total_amount", nullable = false)
    private double totalAmount;

    @OneToMany(mappedBy = "booking")
    private List<Payment> payments;
}

