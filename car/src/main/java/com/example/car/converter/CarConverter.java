package com.example.car.converter;

import com.example.car.data.entity.CarEntity;
import com.example.car.model.Car;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarConverter extends BaseConverter {

    public CarConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }

    public Car convertCarEntityToCar(CarEntity carEntity) {
        return modelMapper.map(carEntity, Car.class);
    }

    public CarEntity convertCarToCarEntity(Car car) {
        return modelMapper.map(car, CarEntity.class);
    }

    public List<Car> convertMultipleStudentEntityToStudent(List<CarEntity> studentEntities) {
        List<Car> cars = new ArrayList<>();
        studentEntities.forEach(carEntity -> cars.add(convertCarEntityToCar(carEntity)));
        return cars;
    }

}
