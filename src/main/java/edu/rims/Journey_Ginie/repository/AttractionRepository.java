package edu.rims.Journey_Ginie.repository;

import edu.rims.Journey_Ginie.entity.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttractionRepository extends JpaRepository<Attraction, String>{
    
}
