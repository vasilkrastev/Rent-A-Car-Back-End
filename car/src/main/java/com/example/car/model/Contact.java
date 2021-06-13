package com.example.car.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
public class Contact {

    private long id;
    private String nameUser;
    private String emailUser;
    private String typeReview;
    private String review;


}
