package edu.rims.Journey_Ginie.service;

import edu.rims.Journey_Ginie.entity.*;
import edu.rims.Journey_Ginie.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;

    public Payment makePayment(String bookingId, String method) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Payment payment = Payment.builder()
                .paymentId("PAY-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase())
                .booking(booking)
                .amountPaid(booking.getTotalAmount())
                .paymentMethod(Payment.PaymentMethod.valueOf(method.toUpperCase()))
                .paymentStatus(Payment.PaymentStatus.COMPLETED)
                .createdBy("system")
                .updatedBy("system")
                .build();

        // Update booking status
        booking.setBookingStatus(Booking.BookingStatus.CONFIRMED);
        bookingRepository.save(booking);

        return paymentRepository.save(payment);
    }

    public List<Payment> getPaymentsByBooking(String bookingId) {
        return paymentRepository.findByBooking_BookingId(bookingId);
    }
}
