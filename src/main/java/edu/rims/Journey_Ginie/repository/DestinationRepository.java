package edu.rims.Journey_Ginie.repository;

import java.util.List;

import edu.rims.Journey_Ginie.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination, String>{

    List<Destination> findByDestinationNameContainingIgnoreCase(String destinationName);
}
