package com.example.car.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CAR")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAR_ID")
    private long id;

    @Column(name = "CAR_BRAND")
    private String brand;

    @Column(name = "CAR_MODEL")
    private String model;

    @Column(name = "CAR_COUPE")
    private String coupe;

    @Column(name = "CAR_DESCRIPTION")
    private String description;

    @Column(name = "CAR_PRICE_PER_DAY")
    private double pricePerDay;

    @Column(name = "CAR_FUEL")
    private String fuel;

    @Column(name = "CAR_TRANSMISSION")
    private String transmission;

    @Column(name = "CAR_YEAR")
    private int year;

    @Column(name = "CAR_IMAGE")
    private String image;

    @Column(name = "CAR_RESERVATIONS")
    private String reservations;


    public void setReservations(String reservations) {
        if (this.reservations == null) {
            this.reservations = reservations + ",";
        } else {
            this.reservations += reservations + ",";
        }

    }
}
