package com.example.car.converter;

import com.example.car.data.entity.CarEntity;
import com.example.car.model.Car;
import com.example.car.model.SimpleCar;
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
    
}
