CREATE TABLE CAR(
   CAR_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
   CAR_BRAND VARCHAR(16) NOT NULL,
   CAR_MODEL VARCHAR(16) NOT NULL,
   CAR_COUPE VARCHAR(16) NOT NULL,
   CAR_DESCRIPTION VARCHAR(1024) NOT NULL,
   CAR_PRICE_PER_DAY DECIMAL NOT NULL,
   CAR_FUEL VARCHAR(16) NOT NULL,
   CAR_TRANSMISSION VARCHAR(16) NOT NULL,
   CAR_YEAR INT NOT NULL
);


CREATE TABLE RESERVATION(
  RESERVATION_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  RESERVATION_YEAR INT NOT NULL,
  CAR_ID BIGINT NOT NULL
);

ALTER TABLE RESERVATION ADD FOREIGN KEY(CAR_ID) REFERENCES CAR(CAR_ID);