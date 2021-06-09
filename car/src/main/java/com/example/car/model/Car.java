package com.example.car.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
public class Car {

    private long id;
    private String brand;
    private String model;
    private String coupe;
    private String description;
    private double pricePerDay;
    private String fuel;
    private String transmission;
    private int year;

}
