package com.example.car.controller;


import com.example.car.model.Car;
import com.example.car.model.SimpleCar;
import com.example.car.service.CarService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarControllerTest {

    private static final long CAR_ID = 1;
    private static final String BRAND = "audi";

    @Mock
    private CarService carService;

    private CarController carController;

    @Before
    public void init() {
        carController = new CarController(carService);
    }

    @Test
    public void getAllCarsTest() {
        //Arrange
        List<SimpleCar> expected = new ArrayList<>();
        when(carService.getAllCars()).thenReturn(expected);

        //Act
        List<SimpleCar> actual = carController.getAllCars();

        //Assert
        assertEquals(expected, actual);
        verify(carService, times(1)).getAllCars();
    }

    @Test
    public void getCarByIdTest() {
        //Arrange
        Car expected = new Car();
        when(carService.getCarById(CAR_ID)).thenReturn(expected);

        //Act
        Car actual = carController.getCar(CAR_ID);

        //Assert
        assertEquals(expected, actual);
        verify(carService, times(1)).getCarById(CAR_ID);
    }

    @Test
    public void searchCarsTest() {
        //Arrange
        List<SimpleCar> expected = new ArrayList<>();
        when(carService.getAllSearchedCars(BRAND)).thenReturn(expected);

        //Act
        List<SimpleCar> actual = carController.searchCars(BRAND);

        //Assert
        assertEquals(expected, actual);
        verify(carService, times(1)).getAllSearchedCars(BRAND);
    }

    @Test
    public void getTopCarsTest() {
        //Arrange
        List<SimpleCar> expected = new ArrayList<>();
        when(carService.getTopCars()).thenReturn(expected);

        //Act
        List<SimpleCar> actual = carController.getTopCars();

        //Assert
        assertEquals(expected, actual);
        verify(carService, times(1)).getTopCars();
    }


}