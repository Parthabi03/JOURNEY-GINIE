package edu.rims.Journey_Ginie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.Journey_Ginie.entity.Tour;

public interface TourRepository extends JpaRepository<Tour, String> {
    
}
