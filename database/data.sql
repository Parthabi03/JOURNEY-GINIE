INSERT INTO destination (
    destination_id, destination_name, destination_description, country, city, 
    image_url, created_by, updated_by
) VALUES 
    (UUID(), 'Big Ben', 'A famous clock tower in London.', 'United Kingdom', 'London', 
     'https://example.com/bigben.jpg', 'admin', 'admin');

INSERT INTO destination (
    destination_id, destination_name, destination_description, country, city, 
    image_url, created_by, updated_by
) VALUES 
    (UUID(), 'Grand Canyon', 'A massive natural canyon in the USA.', 'United States', 'Arizona', 
     'https://example.com/grandcanyon.jpg', 'admin', 'admin');

INSERT INTO destination (
    destination_id, destination_name, destination_description, country, city, 
    image_url, created_by, updated_by
) VALUES 
    (UUID(), 'Eiffel Tower', 'An iconic landmark in Paris.', 'France', 'Paris', 
     'https://example.com/eiffel.jpg', 'admin', 'admin');

INSERT INTO destination (
    destination_id, destination_name, destination_description, country, city, 
    image_url, created_by, updated_by
) VALUES 
    (UUID(), 'Gyeongbokgung Palace', 'A historic palace in Seoul, South Korea.', 'South Korea', 'Seoul', 
     'https://example.com/gyeongbokgung.jpg', 'admin', 'admin');


INSERT INTO destination_place (place_id, destination_id, place_name, place_description, image_url, created_by, updated_by) 
VALUES 
('P001', 'D001', 'Eiffel Tower', 'A wrought-iron lattice tower in Paris, France.', 'https://example.com/eiffel.jpg', 'admin', 'admin'),

('P002', 'D002', 'Grand Canyon', 'A breathtaking natural canyon in Arizona, USA.', 'https://example.com/grandcanyon.jpg', 'admin', 'admin'),

('P003', 'D003', 'Great Wall of China', 'An ancient wall built for protection and now a major tourist attraction.', 'https://example.com/greatwall.jpg', 'admin', 'admin'),

('P004', 'D001', 'Louvre Museum', 'A world-famous art museum in Paris, home to the Mona Lisa.', 'https://example.com/louvre.jpg', 'admin', 'admin'),

('P005', 'D004', 'Santorini', 'A beautiful island in Greece, known for its white-washed houses and blue domes.', 'https://example.com/santorini.jpg', 'admin', 'admin');
