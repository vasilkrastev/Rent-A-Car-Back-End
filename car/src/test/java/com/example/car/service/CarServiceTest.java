package com.example.car.service;

import com.example.car.converter.CarConverter;
import com.example.car.data.entity.CarEntity;
import com.example.car.data.repository.CarRepository;
import com.example.car.exception.NoSuchDataException;
import com.example.car.model.Car;
import com.example.car.model.SimpleCar;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    private final long CAR_ID = 1;
    private final String BRAND = "audi";

    @Mock
    private CarRepository carRepository;

    @Mock
    private CarConverter carConverter;

    private CarService carService;

    @Before
    public void init() {
        carService = new CarService(carRepository, carConverter);
    }

    @Test
    public void getAllCarsTest() {
        //Arrange
        List<SimpleCar> expected = new ArrayList<>();
        List<CarEntity> carEntities = new ArrayList<>();

        when(carRepository.findAll()).thenReturn(carEntities);

        //Act
        List<SimpleCar> actual = carService.getAllCars();

        //Assert
        assertEquals(expected, actual);
        verify(carRepository, times(1)).findAll();
    }

    @Test
    public void getCarByIdTest_ShouldWork() {
        //Arrange
        Car expected = new Car();
        CarEntity carEntity = new CarEntity();

        when(carRepository.findById(CAR_ID)).thenReturn(Optional.of(carEntity));
        when(carConverter.convertCarEntityToCar(carEntity)).thenReturn(expected);

        //Act
        Car actual = carService.getCarById(CAR_ID);

        //Assert
        assertEquals(expected, actual);
        verify(carRepository, times(1)).findById(CAR_ID);
    }

    @Test(expected = NoSuchDataException.class)
    public void getCarByIdTest_ShouldReturnException() {
        //Arrange
        Car expected = new Car();

        //Act
        Car actual = carService.getCarById(CAR_ID);

        //Assert
        assertEquals(expected, actual);
        verify(carRepository, times(1)).findById(CAR_ID);
    }

    @Test
    public void getAllSearchedCarsTest_ShouldWork() {
        //Arrange
        List<CarEntity> carEntities = new ArrayList<>();
        CarEntity carEntity = new CarEntity();
        carEntity.setBrand(BRAND);
        carEntities.add(carEntity);

        when(carRepository.findAll()).thenReturn(carEntities);


        //Act
        List<SimpleCar> actual = carService.getAllSearchedCars(BRAND);

        //Assert
        assertEquals(BRAND, actual.get(0).getBrand());
        verify(carRepository, times(1)).findAll();
    }

    @Test(expected = NoSuchDataException.class)
    public void getAllSearchedCarsTest_ShouldReturnError() {
        //Arrange
        List<CarEntity> carEntities = new ArrayList<>();

        when(carRepository.findAll()).thenReturn(carEntities);

        //Act
        List<SimpleCar> actual = carService.getAllSearchedCars(BRAND);

        //Assert
        assertEquals(BRAND, actual.get(0).getBrand());
        verify(carRepository, times(1)).findAll();
    }

    @Test
    public void getTopCarsTest() {
        //Arrange
        List<SimpleCar> expected = new ArrayList<>();
        List<CarEntity> carEntities = new ArrayList<>();

        when(carRepository.findAll()).thenReturn(carEntities);

        //Act
        List<SimpleCar> actual = carService.getTopCars();

        //Assert
        assertEquals(expected, actual);
        verify(carRepository, times(1)).findAll();
    }

    @Test
    public void updateCarReservationsTest_ShouldWork() {
        //Arrange
        CarEntity carEntity = new CarEntity();
        when(carRepository.findById(CAR_ID)).thenReturn(Optional.of(carEntity));

        //Act
        carService.updateCarReservations(CAR_ID, "NewReservation");
        CarEntity actual = carRepository.findById(CAR_ID).get();

        //Assert
        assertEquals("NewReservation,", actual.getReservations());
    }

    @Test(expected = NoSuchDataException.class)
    public void updateCarReservationsTest_ShouldReturnError() {
        //Arrange

        //Act
        carService.updateCarReservations(CAR_ID, "NewReservation");
        CarEntity actual = carRepository.findById(CAR_ID).get();

        //Assert
        assertEquals("NewReservation,", actual.getReservations());
    }
}