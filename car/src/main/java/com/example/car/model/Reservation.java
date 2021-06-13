package com.example.car.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
public class Reservation {

    private long id;
    private long carId;
    private String nameUser;
    private String emailUser;
    private String numberUser;
    private String dates;

}
