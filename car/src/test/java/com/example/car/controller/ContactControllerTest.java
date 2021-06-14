package com.example.car.controller;

import com.example.car.data.entity.ContactEntity;
import com.example.car.model.Contact;
import com.example.car.service.ContactService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContactControllerTest {

    @Mock
    private ContactService contactService;

    private ContactController contactController;

    @Before
    public void init() {
        contactController = new ContactController(contactService);
    }

    @Test
    public void contactUsTest() {
        //Arrange
        ContactEntity expected = new ContactEntity();
        when(contactService.contact(expected)).thenReturn(expected);

        //Act
        ContactEntity actual = contactController.contactUs(expected);

        //Assert
        assertEquals(expected, actual);
        verify(contactService, times(1)).contact(expected);
    }

    @Test
    public void getContactsTest() {
        //Arrange
        List<Contact> expected = new ArrayList<>();
        when(contactService.getReviews()).thenReturn(expected);

        //Act
        List<Contact> actual = contactController.getTopReviews();

        //Assert
        assertEquals(expected, actual);
        verify(contactService, times(1)).getReviews();
    }

}