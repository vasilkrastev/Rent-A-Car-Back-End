package com.example.car.model;

import com.example.car.data.entity.CarEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
public class SimpleCar {

    private long id;
    private String brand;
    private String model;
    private String coupe;
    private double pricePerDay;
    private String fuel;
    private String transmission;
    private int year;
    private String image;

    public SimpleCar(CarEntity car) {
        this.id = car.getId();
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.coupe = car.getCoupe();
        this.pricePerDay = car.getPricePerDay();
        this.fuel = car.getFuel();
        this.transmission = car.getTransmission();
        this.year = car.getYear();
        this.image = car.getImage();
    }
}