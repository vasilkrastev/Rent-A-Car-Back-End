package com.example.car.controller;

import com.example.car.data.entity.ReservationEntity;
import com.example.car.data.repository.ReservationRepository;
import com.example.car.service.ReservationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/create")
    public ReservationEntity createReservation(@RequestBody ReservationEntity reservationEntity) {
        return reservationService.reserve(reservationEntity);
    }


}
