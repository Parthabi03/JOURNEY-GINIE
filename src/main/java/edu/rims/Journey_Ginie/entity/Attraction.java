package edu.rims.Journey_Ginie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "attraction")
@Getter
@Setter
public class Attraction extends Auditable {

    @Id
    @Column(name = "attraction_id", length = 255, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String attractionId;

    @Column(name = "attraction_name", columnDefinition = "TEXT")
    private String attractionName;

    @Column(name = "attraction_description", columnDefinition = "TEXT")
    private String attractionDescription;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

}
