package edu.rims.Journey_Ginie.service;

import edu.rims.Journey_Ginie.entity.Tour;
import edu.rims.Journey_Ginie.entity.TourPackage;
import edu.rims.Journey_Ginie.entity.User;
import edu.rims.Journey_Ginie.repository.TourPackageRepository;
import edu.rims.Journey_Ginie.repository.TourRepository;
import edu.rims.Journey_Ginie.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TourService {

    private final TourRepository tourRepository;
    private final TourPackageRepository packageRepository;
    private final UserRepository userRepository;

    public Tour addTour(Tour tour, Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (tour.getTourId() == null || tour.getTourId().isBlank())
            tour.setTourId("TOUR-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        tour.setUser(user);
        tour.setCreatedBy("admin");
        tour.setUpdatedBy("admin");
        return tourRepository.save(tour);
    }

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    public Tour getTourById(String id) {
        return tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour not found: " + id));
    }

    public List<Tour> searchByDestination(String destination) {
        return tourRepository.findByTourDestinationContainingIgnoreCase(destination);
    }

    public List<Tour> getByMaxPrice(Double maxPrice) {
        return tourRepository.findByPriceLessThanEqual(maxPrice);
    }

    public List<TourPackage> getPackagesByTour(String tourId) {
        return packageRepository.findByTour_TourId(tourId);
    }

    public Tour updateTour(String id, Tour updated) {
        Tour tour = getTourById(id);
        tour.setTourTitle(updated.getTourTitle());
        tour.setTourDescription(updated.getTourDescription());
        tour.setTourDestination(updated.getTourDestination());
        tour.setPrice(updated.getPrice());
        tour.setTourAvailability(updated.getTourAvailability());
        tour.setTourStartDate(updated.getTourStartDate());
        tour.setTourEndDate(updated.getTourEndDate());
        tour.setImageUrl(updated.getImageUrl());
        tour.setUpdatedBy("admin");
        return tourRepository.save(tour);
    }

    public void deleteTour(String id) {
        tourRepository.deleteById(id);
    }
}
