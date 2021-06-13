package com.example.car.service;

import com.example.car.converter.CarConverter;
import com.example.car.data.entity.CarEntity;
import com.example.car.data.repository.CarRepository;
import com.example.car.exception.NoSuchDataException;
import com.example.car.model.Car;
import com.example.car.model.SimpleCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final CarConverter carConverter;

    @Autowired
    public CarService(CarRepository carRepository, CarConverter carConverter) {
        this.carRepository = carRepository;
        this.carConverter = carConverter;
    }

    public Car getCarById(long id) {
        Optional<CarEntity> carEntity = this.carRepository.findById(id);
        if (!carEntity.isPresent()) {
            throw new NoSuchDataException("No such car");
        }

        return this.carConverter.convertCarEntityToCar(carEntity.get());
    }

    public List<SimpleCar> getAllCars() {
        List<SimpleCar> cars = new ArrayList<>();
        this.carRepository.findAll().forEach(car -> {
            SimpleCar simpleCar = new SimpleCar(car);
            cars.add(simpleCar);
        });
        return cars;
    }

    public List<SimpleCar> getAllSearchedCars(String brand) {
        List<SimpleCar> cars = new ArrayList<>();
        this.carRepository.findAll().forEach(car -> {
            SimpleCar simpleCar = new SimpleCar(car);
            cars.add(simpleCar);
        });

        List<SimpleCar> collectCars = cars.stream().filter(car -> car.getBrand().toLowerCase().equals(brand))
                .collect(Collectors.toList());
        if (collectCars.isEmpty()) {
            throw new NoSuchDataException("No such brand like " + brand);
        }
        return collectCars;
    }

    public List<SimpleCar> getTopCars() {
        List<SimpleCar> cars = new ArrayList<>();
        this.carRepository.findAll().forEach(car -> {
            SimpleCar simpleCar = new SimpleCar(car);
            cars.add(simpleCar);
        });
        return cars.stream().limit(4).collect(Collectors.toList());
    }

    public void updateCarReservations(long id, String dates) {
        CarEntity car = carRepository.findById(id).orElseThrow(() -> new NoSuchDataException("No such car"));
        car.setReservations(dates);
        carRepository.save(car);
    }
}
