package com.example.car.controller;

import com.example.car.data.entity.ReservationEntity;
import com.example.car.service.ReservationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReservationControllerTest {

    @Mock
    private ReservationService reservationService;

    private ReservationController reservationController;

    @Before
    public void init() {
        reservationController = new ReservationController(reservationService);
    }

    @Test
    public void createReservationTest() {
        //Arrange
        ReservationEntity expected = new ReservationEntity();
        when(reservationService.reserve(expected)).thenReturn(expected);

        //Act
        ReservationEntity actual = reservationController.createReservation(expected);

        //Assert
        assertEquals(expected, actual);
        verify(reservationService, times(1)).reserve(expected);
    }

}