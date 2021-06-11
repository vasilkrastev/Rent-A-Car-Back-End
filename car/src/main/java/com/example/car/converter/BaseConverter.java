package com.example.car.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseConverter {
    protected ModelMapper modelMapper;

    @Autowired
    public BaseConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
