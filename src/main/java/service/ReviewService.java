package edu.rims.Journey_Ginie.service;

import edu.rims.Journey_Ginie.dto.ReviewDto;
import edu.rims.Journey_Ginie.entity.*;
import edu.rims.Journey_Ginie.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final TourRepository tourRepository;

    public Review addReview(Integer userId, ReviewDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Tour tour = tourRepository.findById(dto.getTourId())
                .orElseThrow(() -> new RuntimeException("Tour not found"));

        Review review = Review.builder()
                .user(user).tour(tour)
                .rating(dto.getRating())
                .reviewComment(dto.getReviewComment())
                .createdBy("system")
                .updatedBy("system")
                .build();
        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByTour(String tourId) {
        return reviewRepository.findByTour_TourId(tourId);
    }

    public List<Review> getReviewsByUser(Integer userId) {
        return reviewRepository.findByUser_UserId(userId);
    }

    public void deleteReview(Integer id) {
        reviewRepository.deleteById(id);
    }
}
