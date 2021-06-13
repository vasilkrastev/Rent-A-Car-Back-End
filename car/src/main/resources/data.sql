CREATE TABLE IF NOT EXISTS CAR (
   CAR_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
   CAR_BRAND VARCHAR(16) NOT NULL,
   CAR_MODEL VARCHAR(16) NOT NULL,
   CAR_COUPE VARCHAR(16) NOT NULL,
   CAR_DESCRIPTION VARCHAR(1024) NOT NULL,
   CAR_PRICE_PER_DAY DECIMAL NOT NULL,
   CAR_FUEL VARCHAR(16) NOT NULL,
   CAR_TRANSMISSION VARCHAR(16) NOT NULL,
   CAR_YEAR INT NOT NULL,
   CAR_IMAGE VARCHAR(26) NOT NULL,
   CAR_RESERVATIONS VARCHAR(1024)
);

CREATE TABLE IF NOT EXISTS RESERVATION(
  RESERVATION_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  CAR_ID BIGINT,
  USER_NAME VARCHAR(26),
  USER_EMAIL VARCHAR(26),
  USER_NUMBER VARCHAR(26),
  RESERVATION_DATES VARCHAR(1024)
);

CREATE TABLE IF NOT EXISTS CONTACT(
    CONTACT_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    USER_NAME VARCHAR(26),
    USER_EMAIL VARCHAR(26),
    REVIEW_TYPE VARCHAR(26),
    REVIEW VARCHAR(1024)
);

ALTER TABLE RESERVATION ADD FOREIGN KEY(CAR_ID) REFERENCES CAR(CAR_ID);

INSERT INTO CAR(CAR_BRAND, CAR_MODEL, CAR_COUPE, CAR_DESCRIPTION,
                CAR_PRICE_PER_DAY, CAR_FUEL, CAR_TRANSMISSION, CAR_YEAR, CAR_IMAGE, CAR_RESERVATIONS) VALUES
('Toyota', 'Yaris', 'Hatchback', 'Up to 2019, Toyota had used the Yaris nameplate on export versions of various Japanese-market models, with some markets receiving the same vehicles under the Toyota Echo name through 2005. ', 70, 'petrol', 'Manual', 2018, 'toyota.jpg', ''),
('Audi', 'A6', 'Sedan', 'The 2019 Audi A6 comes in three trims: Premium, Premium Plus, and Prestige. ', 150, 'diesel', 'Automatic', 2019, 'audi.jpg', ''),
('Ford', 'F150', 'Truck', 'Despite being a big truck, this Ford delivers a smooth ride, even over rough pavement. ', 300, 'petrol', 'Automatic', 2016, 'ford.jpg', ''),
('Chevrolet', 'Captiva', 'Jeep', 'The Chevrolet Captiva is a compact crossover SUV developed by General Motors. ', 170, 'diesel', 'Automatic', 2018, 'chevrolet.jpg', ''),
('Citroen', 'Cactus', 'Jeet', 'The C4 Cactus is considered a compact SUV, although it is based on the PSA PF1 platform that underpins the smaller Citroën C3 and DS3.', 260, 'petrol', 'Manual', 2020, 'citroen.jpg', ''),
('Mitsubishi', 'Lancer', 'Sedan', 'The Mitsubishi Lancer is an automobile nameplate produced by the Japanese manufacturer Mitsubishi Motors since 1973.', 210, 'petrol', 'Manual', 2017, 'mitsubishi.jpg', ''),
('Suzuki', 'Ignis', 'Hatchback', 'The Maruti Ignis has 1 Petrol Engine on offer. The Petrol engine is 1197 cc . It is available with the Manual & Automatic transmission. ', 70, 'diesel', 'Manual', 2019, 'suzuki.jpg', ''),
('BMW', '320', 'Sedan', 'The BMW 320 was a car manufactured by Bayerische Motoren Werke AG also known as BMW in Germany from 1937 to 1938, the successor to the 319-based BMW 329. ', 250, 'petrol', 'Manual', 2015, 'bmw.jpg', ''),
('Honda', 'Civic', 'Coupe', 'The Honda Civic is a line of cars manufactured by Honda. Originally a subcompact, the Civic has gone through several generational changes, becoming both larger and more upscale, moving into the compact car segment. ', 240, 'petrol', 'Manual', 2018, 'honda.jpg', ''),
('Fiat', 'Bravo', 'Hatchback', 'The Fiat Bravo (Type 198) is a small family car produced by Italian manufacturer Fiat from 2007 to 2014. ', 30, 'petrol', 'Manual', 2007, 'fiat.jpg', ''),
('Dacia', 'Duster', 'Jeep', 'The Dacia Duster is a compact crossover SUV produced and marketed jointly by the French manufacturer Renault and its Romanian subsidiary Dacia since 2010. ', 100, 'diesel', 'Manual', 2018, 'dacia.jpg', '');

