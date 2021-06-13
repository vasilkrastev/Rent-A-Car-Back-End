package com.example.car.controller;

import com.example.car.model.Car;
import com.example.car.model.SimpleCar;
import com.example.car.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin(origins = "http://localhost:8090", allowedHeaders = "")
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @ResponseBody
    @GetMapping("/all")
    public List<SimpleCar> getAllCars() {
        return carService.getAllCars();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Car getCar(@PathVariable long id) {
        return carService.getCarById(id);
    }

    @ResponseBody
    @GetMapping("/search/{brand}")
    public List<SimpleCar> searchCars(@PathVariable String brand) {
        List<String> brands = Arrays.asList(brand.toLowerCase().split(","));
        return brands.stream().map(carService::getAllSearchedCars)
                .flatMap(Collection::stream).collect(Collectors.toList());
    }

    @ResponseBody
    @GetMapping("/top")
    public List<SimpleCar> topCars() {
        return carService.getTopCars();
    }

}
