package com.example.car.service;

import com.example.car.converter.ContactConverter;
import com.example.car.data.entity.ContactEntity;
import com.example.car.data.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
