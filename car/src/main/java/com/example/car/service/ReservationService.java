package com.example.car.service;

import com.example.car.data.entity.ReservationEntity;
import com.example.car.data.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final CarService carService;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, CarService carService) {
        this.reservationRepository = reservationRepository;
        this.carService = carService;
    }

    public ReservationEntity reserve(ReservationEntity reservationEntity) {
        reservationRepository.save(reservationEntity);

        carService.updateCarReservations(reservationEntity.getCarId(), reservationEntity.getDates());

        return reservationEntity;

    }
}
