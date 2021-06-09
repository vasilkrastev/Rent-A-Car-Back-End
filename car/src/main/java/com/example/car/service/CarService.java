package com.example.car.service;

import com.example.car.converter.CarConverter;
import com.example.car.data.entity.CarEntity;
import com.example.car.data.repository.CarRepository;
import com.example.car.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final CarConverter carConverter;

    @Autowired
    public CarService(CarRepository carRepository, CarConverter carConverter) {
        this.carRepository = carRepository;
        this.carConverter = carConverter;
    }

    public List<Car> getAllCars() {
        List<CarEntity> cars = new ArrayList<>();
        this.carRepository.findAll().forEach(cars::add);
        return this.carConverter.convertMultipleStudentEntityToStudent(cars);
    }
}
