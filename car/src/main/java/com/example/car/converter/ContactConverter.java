package com.example.car.converter;

import com.example.car.data.entity.CarEntity;
import com.example.car.data.entity.ContactEntity;
import com.example.car.model.Car;
import com.example.car.model.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactConverter extends BaseConverter{

    public ContactConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }

    public Contact convertContactEntityToContact(ContactEntity contactEntity) {
        return modelMapper.map(contactEntity, Contact.class);
    }

    public ContactEntity convertContactToContactEntity(Contact contact) {
        return modelMapper.map(contact, ContactEntity.class);
    }

    public List<Contact> convertMultipleContactEntityToContact(List<ContactEntity> contactEntities) {
        List<Contact> contacts = new ArrayList<>();
        contactEntities.forEach(contactEntity -> contacts.add(convertContactEntityToContact(contactEntity)));
        return contacts;
    }



}
