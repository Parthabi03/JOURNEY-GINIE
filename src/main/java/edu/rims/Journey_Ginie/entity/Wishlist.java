package edu.rims.Journey_Ginie.entity;

import java.sql.Date;

import edu.rims.Journey_Ginie.constant.WishlistStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "wishlist")
public class Wishlist extends Auditable {

    @Id
    @Column(name = "wishlist_id", length = 255)
    private String wishlistId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "destination_name", nullable = false, length = 255)
    private String destinationName;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private WishlistStatus status;

    @Column(name = "travel_date")
    @Temporal(TemporalType.DATE)
    private Date travelDate;

    @Column(name = "category", length = 100)
    private String category;
}
