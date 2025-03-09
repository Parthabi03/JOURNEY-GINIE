package edu.rims.Journey_Ginie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "destination_place")
public class DestinationPlace {

    @Id
    @Column(name = "place_id", length = 255)
    private String placeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @Column(name = "place_name", length = 150)
    private String placeName;

    @Column(name = "place_description")
    private String placeDescription;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "created_date", updatable = false)
    private Timestamp createdDate;

    @Column(name = "updated_date")
    private Timestamp updatedDate;

    @Column(name = "created_by", length = 50)
    private String createdBy;

    @Column(name = "updated_by", length = 50)
    private String updatedBy;

    @PrePersist
    protected void onCreate() {
        createdDate = new Timestamp(System.currentTimeMillis());
        updatedDate = createdDate;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = new Timestamp(System.currentTimeMillis());
    }
}
