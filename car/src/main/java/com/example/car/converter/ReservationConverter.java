package com.example.car.converter;

import com.example.car.data.entity.ReservationEntity;
import com.example.car.model.Reservation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ReservationConverter extends BaseConverter {

    public ReservationConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }

    public Reservation convertReservationEntityToReservation(ReservationEntity reservationEntity) {
        return modelMapper.map(reservationEntity, Reservation.class);
    }

    public ReservationEntity convertReservationToReservationEntity(Reservation reservation) {
        return modelMapper.map(reservation, ReservationEntity.class);
    }

}
