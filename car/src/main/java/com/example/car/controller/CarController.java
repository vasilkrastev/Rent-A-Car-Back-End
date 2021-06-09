package com.example.car.controller;

import com.example.car.model.Car;
import com.example.car.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @ResponseBody
    @GetMapping("/all")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/search")
    public String searchCars(Model model) {
        return filterCars(model);
    }

    @PostMapping("/filtered")
    public String submitCars(Model model, @RequestBody String searchedCars) {
        List<String> cars = Arrays.asList(searchedCars.split("&"));
        cars.forEach(System.out::println);
        return filterCars(model);
    }

    private String filterCars(Model model) {
//        model.addAttribute("output", );
        model.addAttribute("cars", carService.getAllCars());

        return "dummy";
    }
}
