package edu.rims.Journey_Ginie.service;

import edu.rims.Journey_Ginie.dto.BookingDto;
import edu.rims.Journey_Ginie.entity.*;
import edu.rims.Journey_Ginie.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final TourRepository tourRepository;
    private final DestinationRepository destinationRepository;

    public Booking createBooking(Integer userId, BookingDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Tour tour = tourRepository.findById(dto.getTourId())
                .orElseThrow(() -> new RuntimeException("Tour not found"));
        Destination dest = destinationRepository.findById(dto.getDestinationId())
                .orElseThrow(() -> new RuntimeException("Destination not found"));

        double totalAmount = tour.getPrice() * dto.getNumberOfGuests();

        Booking booking = Booking.builder()
                .bookingId("BK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase())
                .user(user)
                .tour(tour)
                .destination(dest)
                .numberOfGuests(dto.getNumberOfGuests())
                .totalAmount(totalAmount)
                .bookingStatus(Booking.BookingStatus.PENDING)
                .createdBy("system")
                .updatedBy("system")
                .build();
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<Booking> getBookingsByUser(Integer userId) {
        return bookingRepository.findByUser_UserId(userId);
    }

    public Booking getBookingById(String id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found: " + id));
    }

    public Booking updateStatus(String id, String status) {
        Booking booking = getBookingById(id);
        booking.setBookingStatus(Booking.BookingStatus.valueOf(status.toUpperCase()));
        booking.setUpdatedBy("system");
        return bookingRepository.save(booking);
    }

    public void cancelBooking(String id) {
        updateStatus(id, "CANCELED");
    }
}
