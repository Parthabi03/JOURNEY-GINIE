--Database
CREATE SCHEMA JOURNEY_GINIE;
USE JOURNEY_GINIE;
--table
-- Users Table
CREATE TABLE user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(100) NOT NULL,
    user_email VARCHAR(150) NOT NULL UNIQUE,
    user_phone_number VARCHAR(20),
    user_password VARCHAR(255) NOT NULL,
    user_adharcard VARCHAR(255) NOT NULL,
    user_image_url TEXT NULL,
    user_gender VARCHAR(20),
    creaed_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)

);

-- Tours Table
CREATE TABLE tour (
    tour_id VARCHAR(255) PRIMARY KEY,
    tour_title VARCHAR(200) NOT NULL,
    tour_description TEXT NULL,
    tour_destination VARCHAR(100) NOT NULL,
    price DOUBLE NOT NULL,
    tour_availability INT NOT NULL,
    tour_start_date DATE NOT NULL,
    tour_end_date DATE NOT NULL,
    creaed_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)

);

-- Bookings Table
CREATE TABLE booking (
    booking_id VARCHAR(255) PRIMARY KEY,
    user_id INT NOT NULL,
    tour_id VARCHAR(255) NOT NULL,
    booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    booking_status ENUM('PENDING', 'CONFIRMED', 'CANCELED','COMPLETED') DEFAULT 'PENDING',
    number_of_guests INT NOT NULL,
    total_amount DOUBLE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE,
    FOREIGN KEY (tour_id) REFERENCES tour(tour_id) ON DELETE CASCADE,
    creaed_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)
);

-- Payments Table
CREATE TABLE payment (
    payment_id VARCHAR(255) PRIMARY KEY,
    booking_id INT NOT NULL,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    payment_method ENUM('CREDIT_CARD', 'PAYPAL', 'OTHER') NOT NULL,
    payment_status ENUM('COMPLETED', 'PENDING', 'FAILED') DEFAULT 'PENDING',
    amount_paid DOUBLE NOT NULL,
    FOREIGN KEY (booking_id) REFERENCES booking(booking_id) ON DELETE CASCADE,
    creaed_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)
);

-- Reviews Table
CREATE TABLE review (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    tour_id VARCHAR(255) PRIMARY KEY,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    review_comment TEXT,
    review_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE,
    FOREIGN KEY (tour_id) REFERENCES tour(tour_id) ON DELETE CASCADE,
    creaed_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)
);

-- Destination Table
    updated_CREATE TABLE destination (
    destination_id VARCHAR(255) PRIMARY KEY,
    destination_name VARCHAR(100) NOT NULL,
    destination_description TEXT,
    country VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    image_url VARCHAR(255),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50)
);
CREATE TABLE wishlist (
    wishlist_id VARCHAR(255) PRIMARY KEY,
    user_id INT NOT NULL,
    destination_name VARCHAR(255) NOT NULL,
    tour_id VARCHAR(255) DEFAULT NULL,
    date_added TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    wishlist_notes TEXT,
    wishlist_status ENUM('ACTIVE', 'REMOVED') DEFAULT 'ACTIVE',
    travel_date DATE,
    category VARCHAR(100),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (tour_id) REFERENCES tour(tour_id)
);


   

