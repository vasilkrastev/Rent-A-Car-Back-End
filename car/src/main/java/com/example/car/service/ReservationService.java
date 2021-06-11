package com.example.car.service;

import com.example.car.converter.ReservationConverter;
import com.example.car.data.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationConverter reservationConverter;
    private final ReservationRepository reservationRepository;

    @Autowired

    public ReservationService(ReservationConverter reservationConverter, ReservationRepository reservationRepository) {
        this.reservationConverter = reservationConverter;
        this.reservationRepository = reservationRepository;
    }
}
