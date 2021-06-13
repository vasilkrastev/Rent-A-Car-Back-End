package com.example.car.controller;

import com.example.car.data.entity.ReservationEntity;
import com.example.car.data.repository.ReservationRepository;
import com.example.car.model.Reservation;
import com.example.car.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "")
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationRepository reservationRepository;
    private ReservationService reservationService;

    public ReservationController(ReservationRepository reservationRepository, ReservationService reservationService) {
        this.reservationRepository = reservationRepository;
        this.reservationService = reservationService;
    }

    @PostMapping("/create")
    public ReservationEntity createReservation(@RequestBody ReservationEntity reservationEntity){
        return reservationService.reserve(reservationEntity);
    }


}