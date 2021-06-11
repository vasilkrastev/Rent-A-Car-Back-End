package com.example.car.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "RESERVATION")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_ID")
    private long id;

    @Column(name = "CAR_ID")
    private long carId;

    @Column(name = "USER_NAME")
    private String nameUser;

    @Column(name = "USER_EMAIL")
    private String emailUser;

    @Column(name = "USER_NUMBER")
    private String numberUser;

    @Column(name = "RESERVATION_DATES")
    private String dates;

}
