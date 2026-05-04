package edu.rims.Journey_Ginie.service;

import edu.rims.Journey_Ginie.entity.Destination;
import edu.rims.Journey_Ginie.entity.DestinationPlace;
import edu.rims.Journey_Ginie.repository.DestinationPlaceRepository;
import edu.rims.Journey_Ginie.repository.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DestinationService {

    private final DestinationRepository destinationRepository;
    private final DestinationPlaceRepository placeRepository;

    public Destination addDestination(Destination dest) {
        if (dest.getDestinationId() == null || dest.getDestinationId().isBlank())
            dest.setDestinationId("DEST-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        dest.setCreatedBy("admin");
        dest.setUpdatedBy("admin");
        return destinationRepository.save(dest);
    }

    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    public Destination getById(String id) {
        return destinationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destination not found: " + id));
    }

    public List<Destination> searchByKeyword(String keyword) {
        return destinationRepository.findByDestinationNameContainingIgnoreCase(keyword);
    }

    public List<Destination> getByCountry(String country) {
        return destinationRepository.findByCountryIgnoreCase(country);
    }

    public Destination updateDestination(String id, Destination updated) {
        Destination dest = getById(id);
        dest.setDestinationName(updated.getDestinationName());
        dest.setDestinationDescription(updated.getDestinationDescription());
        dest.setCountry(updated.getCountry());
        dest.setCity(updated.getCity());
        dest.setImageUrl(updated.getImageUrl());
        dest.setUpdatedBy("admin");
        return destinationRepository.save(dest);
    }

    public void deleteDestination(String id) {
        destinationRepository.deleteById(id);
    }

    public List<DestinationPlace> getPlacesByDestination(String destinationId) {
        return placeRepository.findByDestination_DestinationId(destinationId);
    }
}
