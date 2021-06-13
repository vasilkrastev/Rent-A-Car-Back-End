package com.example.car.service;

import com.example.car.converter.ContactConverter;
import com.example.car.data.entity.ContactEntity;
import com.example.car.data.repository.ContactRepository;
import com.example.car.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {
    private ContactConverter contactConverter;
    private ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactConverter contactConverter, ContactRepository contactRepository) {
        this.contactConverter = contactConverter;
        this.contactRepository = contactRepository;
    }

    public ContactEntity contact(ContactEntity newContactEntity) {
        ContactEntity contactEntity = new ContactEntity();

        contactEntity.setNameUser(newContactEntity.getNameUser());
        contactEntity.setEmailUser(newContactEntity.getEmailUser());
        contactEntity.setTypeReview(newContactEntity.getTypeReview());
        contactEntity.setReview(newContactEntity.getReview());

        contactRepository.save(contactEntity);

        return contactEntity;
    }

    public List<Contact> getReviews() {
        List<ContactEntity> contacts = new ArrayList<>();
        this.contactRepository.findAll().forEach(contacts::add);
        return contactConverter.convertMultipleContactEntityToContact(contacts.stream()
                .limit(4).collect(Collectors.toList()));
    }
}
