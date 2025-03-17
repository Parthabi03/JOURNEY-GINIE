INSERT INTO destination (destination_id, destination_name, destination_description, country, city, image_url, created_by, updated_by)
VALUES
('DEST001', 'Eiffel Tower', 'A wrought-iron lattice tower in Paris, one of the most famous landmarks in the world.', 'France', 'Paris', 'https://example.com/eiffel.jpg', 'admin', 'admin'),
('DEST002', 'Grand Canyon', 'A magnificent natural canyon known for its layered red rock formations.', 'USA', 'Arizona', 'https://example.com/grandcanyon.jpg', 'admin', 'admin'),
('DEST003', 'Great Wall of China', 'An ancient series of walls and fortifications stretching across northern China.', 'China', 'Beijing', 'https://example.com/greatwall.jpg', 'admin', 'admin'),
('DEST004', 'Machu Picchu', 'A historic Incan citadel set high in the Andes Mountains.', 'Peru', 'Cusco', 'https://example.com/machu_picchu.jpg', 'admin', 'admin'),
('DEST005', 'Santorini', 'A beautiful Greek island known for its white-washed buildings and blue domes.', 'Greece', 'Santorini', 'https://example.com/santorini.jpg', 'admin', 'admin'),
('DEST006', 'Sydney Opera House', 'An iconic performing arts venue with a unique sail-like design.', 'Australia', 'Sydney', 'https://example.com/sydneyopera.jpg', 'admin', 'admin'),
('DEST007', 'Taj Mahal', 'A stunning white marble mausoleum built by Emperor Shah Jahan.', 'India', 'Agra', 'https://example.com/tajmahal.jpg', 'admin', 'admin'),
('DEST008', 'Mount Fuji', 'Japan’s highest mountain and an active volcano, a popular destination for climbers.', 'Japan', 'Shizuoka', 'https://example.com/mountfuji.jpg', 'admin', 'admin');

INSERT INTO destination_place (place_id, destination_id, place_name, place_description, image_url, created_by, updated_by)
VALUES
-- Places in Eiffel Tower, France
('PLACE001', 'DEST001', 'Summit of Eiffel Tower', 'The highest accessible point of the Eiffel Tower with breathtaking views.', 'https://example.com/eiffel_summit.jpg', 'admin', 'admin'),
('PLACE002', 'DEST001', 'Eiffel Tower Light Show', 'A mesmerizing light show that occurs every night.', 'https://example.com/eiffel_lightshow.jpg', 'admin', 'admin'),

-- Places in Grand Canyon, USA
('PLACE003', 'DEST002', 'Grand Canyon Skywalk', 'A glass bridge that extends over the canyon for thrilling views.', 'https://example.com/grandcanyon_skywalk.jpg', 'admin', 'admin'),
('PLACE004', 'DEST002', 'Havasu Falls', 'A beautiful waterfall located in the Grand Canyon.', 'https://example.com/havasu_falls.jpg', 'admin', 'admin'),

-- Places in Great Wall of China, China
('PLACE005', 'DEST003', 'Badaling Section', 'The most popular and well-preserved section of the Great Wall.', 'https://example.com/badaling.jpg', 'admin', 'admin'),
('PLACE006', 'DEST003', 'Mutianyu Section', 'A scenic and less crowded section of the Great Wall.', 'https://example.com/mutianyu.jpg', 'admin', 'admin'),

-- Places in Machu Picchu, Peru
('PLACE007', 'DEST004', 'Sun Gate', 'The main entrance to Machu Picchu for those hiking the Inca Trail.', 'https://example.com/sungate.jpg', 'admin', 'admin'),
('PLACE008', 'DEST004', 'Temple of the Sun', 'An important religious site in Machu Picchu.', 'https://example.com/temple_of_sun.jpg', 'admin', 'admin'),

-- Places in Santorini, Greece
('PLACE009', 'DEST005', 'Oia Village', 'A picturesque village with stunning sunset views.', 'https://example.com/oia.jpg', 'admin', 'admin'),
('PLACE010', 'DEST005', 'Red Beach', 'A unique beach with red volcanic sand.', 'https://example.com/red_beach.jpg', 'admin', 'admin'),

-- Places in Sydney Opera House, Australia
('PLACE011', 'DEST006', 'Concert Hall', 'The largest venue inside the Opera House for major performances.', 'https://example.com/concerthall.jpg', 'admin', 'admin'),
('PLACE012', 'DEST006', 'Bennelong Restaurant', 'A fine dining experience inside the Opera House.', 'https://example.com/bennelong.jpg', 'admin', 'admin'),

-- Places in Taj Mahal, India
('PLACE013', 'DEST007', 'Main Mausoleum', 'The central tomb chamber of the Taj Mahal.', 'https://example.com/main_mausoleum.jpg', 'admin', 'admin'),
('PLACE014', 'DEST007', 'Taj Mahal Gardens', 'Beautiful Persian-style gardens surrounding the monument.', 'https://example.com/taj_gardens.jpg', 'admin', 'admin'),

-- Places in Mount Fuji, Japan
('PLACE015', 'DEST008', 'Chureito Pagoda', 'A stunning viewpoint for Mount Fuji.', 'https://example.com/chureito.jpg', 'admin', 'admin'),
('PLACE016', 'DEST008', 'Lake Kawaguchi', 'A scenic lake offering amazing views of Mount Fuji.', 'https://example.com/lake_kawaguchi.jpg', 'admin', 'admin');

INSERT INTO tour (tour_id, tour_title, tour_description, tour_destination, price, tour_availability, tour_start_date, tour_end_date, user_id, created_by, updated_by)
VALUES
-- Wildlife Tour
('TOUR001', 'Wildlife', '15+ Wildlife packages available.', 'Kenya', 2500.00, 10, '2025-07-10', '2025-07-20', 1, 'admin', 'admin'),

-- Adventure Tour
('TOUR002', 'Adventure', '20+ Adventure packages available.', 'Nepal', 1800.00, 8, '2025-09-15', '2025-09-30', 2, 'admin', 'admin'),

-- Honeymoon Tour
('TOUR003', 'Honeymoon', '10+ Honeymoon packages available.', 'Maldives', 5000.00, 5, '2025-02-10', '2025-02-17', 3, 'admin', 'admin'),

-- Freedom Tour
('TOUR004', 'Freedom', '25+ Freedom packages available.', 'Europe', 3000.00, 12, '2025-05-01', '2025-05-31', 4, 'admin', 'admin');


INSERT INTO user (user_name, user_email, user_phone_number, user_password, user_adharcard, user_image_url, user_gender, created_by, updated_by)
VALUES
-- User 1
('Rahul Sharma', 'rahul.sharma@example.com', '+91 9876543210', 'hashed_password_1', '1234-5678-9012', 'https://example.com/rahul.jpg', 'Male', 'admin', 'admin'),

-- User 2
('Priya Singh', 'priya.singh@example.com', '+91 8765432109', 'hashed_password_2', '2345-6789-0123', 'https://example.com/priya.jpg', 'Female', 'admin', 'admin'),

-- User 3
('Amit Patel', 'amit.patel@example.com', '+91 7654321098', 'hashed_password_3', '3456-7890-1234', 'https://example.com/amit.jpg', 'Male', 'admin', 'admin'),

-- User 4
('Neha Verma', 'neha.verma@example.com', '+91 6543210987', 'hashed_password_4', '4567-8901-2345', 'https://example.com/neha.jpg', 'Female', 'admin', 'admin');

INSERT INTO tour_package (package_id, package_title, package_description, package_destination, package_price, package_availability, package_start_date, package_end_date, tour_id) VALUES
-- Wildlife Packages
('WILD001', 'Serengeti Safari Experience', 'Explore the vast Serengeti with guided wildlife tours.', 'Tanzania', 2500.00, 10, '2025-06-10', '2025-06-20', 1),
('WILD002', 'Amazon Rainforest Expedition', 'Immerse yourself in the biodiversity of the Amazon.', 'Brazil', 3200.00, 8, '2025-07-05', '2025-07-15', 2),

-- Adventure Packages
('ADV001', 'Mount Everest Base Camp Trek', 'A challenging trek to the base of the world’s highest peak.', 'Nepal', 1800.00, 15, '2025-09-01', '2025-09-15', 3),
('ADV002', 'Grand Canyon Rafting Adventure', 'A thrilling whitewater rafting experience in the Grand Canyon.', 'USA', 2200.00, 12, '2025-08-10', '2025-08-20', 4),

-- Honeymoon Packages
('HONEY001', 'Maldives Luxury Retreat', 'A romantic getaway in the Maldives with private villas.', 'Maldives', 5000.00, 5, '2025-05-20', '2025-05-30', 5),
('HONEY002', 'Paris Romantic Escape', 'Explore the city of love with a romantic itinerary.', 'France', 3500.00, 7, '2025-06-15', '2025-06-25', 6),

-- Freedom Packages
('FREE001', 'Bali Solo Escape', 'A self-paced journey through Bali’s serene beaches and cultural hotspots.', 'Indonesia', 1800.00, 10, '2025-07-10', '2025-07-20', 7),
('FREE002', 'European Backpacking Adventure', 'Explore multiple European cities with full flexibility.', 'Europe', 2800.00, 12, '2025-09-05', '2025-09-25', 8);
