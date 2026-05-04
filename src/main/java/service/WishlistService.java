package edu.rims.Journey_Ginie.service;

import edu.rims.Journey_Ginie.entity.*;
import edu.rims.Journey_Ginie.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;
    private final TourRepository tourRepository;

    public Wishlist addToWishlist(Integer userId, String destinationName,
                                   String tourId, String category) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Tour tour = tourId != null ? tourRepository.findById(tourId).orElse(null) : null;

        Wishlist item = Wishlist.builder()
                .wishlistId("WL-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase())
                .user(user).tour(tour)
                .destinationName(destinationName)
                .category(category)
                .wishlistStatus(Wishlist.WishlistStatus.ACTIVE)
                .build();
        return wishlistRepository.save(item);
    }

    public List<Wishlist> getWishlistByUser(Integer userId) {
        return wishlistRepository.findByUser_UserId(userId);
    }

    public void removeFromWishlist(String wishlistId) {
        Wishlist item = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new RuntimeException("Wishlist item not found"));
        item.setWishlistStatus(Wishlist.WishlistStatus.REMOVED);
        wishlistRepository.save(item);
    }
}
