package edu.rims.Journey_Ginie.entity;

import java.time.LocalDateTime;

import edu.rims.Journey_Ginie.constant.PaymentMethod;
import edu.rims.Journey_Ginie.constant.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment extends Auditable {

    @Id
    @Column(name = "payment_id", nullable = false)
    private String paymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id", nullable = false)
    private Booking booking;

    @Column(name = "payment_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    @Column(name = "amount_paid", nullable = false)
    private double amountPaid;

}

