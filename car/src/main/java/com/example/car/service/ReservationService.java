package com.example.car.service;

import com.example.car.converter.ReservationConverter;
import com.example.car.data.entity.ReservationEntity;
import com.example.car.data.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationConverter reservationConverter;
    private final ReservationRepository reservationRepository;
    private final CarService carService;

    @Autowired
    public ReservationService(ReservationConverter reservationConverter, ReservationRepository reservationRepository, CarService carService) {
        this.reservationConverter = reservationConverter;
        this.reservationRepository = reservationRepository;
        this.carService = carService;
    }

    public ReservationEntity reserve(ReservationEntity newReservationEntity) {
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setCarId(newReservationEntity.getCarId());
        reservationEntity.setNameUser(newReservationEntity.getNameUser());
        reservationEntity.setEmailUser(newReservationEntity.getEmailUser());
        reservationEntity.setNumberUser(newReservationEntity.getNumberUser());
        reservationEntity.setDates(newReservationEntity.getDates());

        reservationRepository.save(reservationEntity);

        carService.updateCarReservations(reservationEntity.getCarId(), reservationEntity.getDates());

        return reservationEntity;

    }
}
