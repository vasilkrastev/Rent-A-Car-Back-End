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
@Table(name = "CONTACT")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTACT_ID")
    private long id;

    @Column(name = "USER_NAME")
    private String nameUser;

    @Column(name = "USER_EMAIL")
    private String emailUser;

    @Column(name = "REVIEW_TYPE")
    private String typeReview;

    @Column(name = "REVIEW")
    private String review;

}
