package com.example.car.controller;

import com.example.car.data.entity.ContactEntity;
import com.example.car.service.ContactService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "")
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/us")
    public ContactEntity contactUs(@RequestBody ContactEntity contactEntity) {
        return contactService.contact(contactEntity);
    }
}
