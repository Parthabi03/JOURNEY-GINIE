package edu.rims.Journey_Ginie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.Journey_Ginie.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, String>{
    
}
