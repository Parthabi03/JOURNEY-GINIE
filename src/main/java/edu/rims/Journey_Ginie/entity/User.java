package edu.rims.Journey_Ginie.entity;


import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter

public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name", nullable = false, length = 100)
    private String userName;

    @Column(name = "user_email", nullable = false, unique = true, length = 150)
    private String userEmail;

    @Column(name = "user_phone_number", length = 20)
    private String userPhoneNumber;

    @Column(name = "user_password", nullable = false, length = 255)
    private String userPassword;

    @Column(name = "user_adharcard", nullable = false, length = 255)
    private String userAdharcard;

    @Column(name = "user_image_url", columnDefinition = "TEXT")
    private String userImageUrl;

    @OneToMany(mappedBy = "user")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    private List<Wishlist> wishlists;

    // @OneToMany(mappedBy = "user")
    // private List<Destination> destinations;

    @OneToMany(mappedBy = "user")
    private List<Tour> tours;
    
    
}
