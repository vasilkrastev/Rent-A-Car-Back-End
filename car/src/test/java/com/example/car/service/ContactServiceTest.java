package com.example.car.service;

import com.example.car.converter.ContactConverter;
import com.example.car.data.entity.ContactEntity;
import com.example.car.data.repository.ContactRepository;
import com.example.car.model.Contact;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTest {

    @Mock
    private ContactRepository contactRepository;

    @Mock
    private ContactConverter contactConverter;

    private ContactService contactService;

    @Before
    public void init() {
        contactService = new ContactService(contactConverter, contactRepository);
    }

    @Test
    public void contactUsTest() {

        //Arrange
        ContactEntity expected = new ContactEntity();
        expected.setNameUser("vasil");
        expected.setEmailUser("vasil@abv.bg");
        expected.setTypeReview("cool");
        expected.setReview("cool");

        when(contactRepository.save(expected)).thenReturn(expected);

        //Act
        ContactEntity actual = contactService.contact(expected);

        //Assert
        assertEquals(expected, actual);
        verify(contactRepository, times(1)).save(expected);
    }

    @Test
    public void getReviewsTest() {
        //Arrange
        List<Contact> expected = new ArrayList<>();
        List<ContactEntity> contactEntities = new ArrayList<>();

        when(contactRepository.findAll()).thenReturn(contactEntities);

        //Act
        List<Contact> actual = contactService.getReviews();

        //Assert
        Assert.assertEquals(expected, actual);
        verify(contactRepository, times(1)).findAll();
    }
}