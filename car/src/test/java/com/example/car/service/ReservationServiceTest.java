package com.example.car.service;

import com.example.car.data.entity.ReservationEntity;
import com.example.car.data.repository.ReservationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;


    @Mock
    private CarService carService;

    private ReservationService reservationService;

    @Before
    public void init() {
        reservationService = new ReservationService(reservationRepository, carService);
    }

    @Test
    public void reserveTest() {
        //Arrange
        ReservationEntity expected = new ReservationEntity();
        expected.setNameUser("vasil");
        expected.setEmailUser("vasil@abv.bg");
        expected.setNumberUser("0882736534");
        expected.setDates("23-12-2020");

        when(reservationRepository.save(expected)).thenReturn(expected);

        //Act
        ReservationEntity actual = reservationService.reserve(expected);

        //Assert
        assertEquals(expected, actual);
        verify(reservationRepository, times(1)).save(expected);

    }

}