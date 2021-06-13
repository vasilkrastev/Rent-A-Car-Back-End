package com.example.car.controller;

import com.example.car.data.entity.ContactEntity;
import com.example.car.model.Contact;
import com.example.car.service.ContactService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8090", allowedHeaders = "")
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

    @GetMapping("/top")
    public List<Contact> getTopReviews(){
        return contactService.getReviews();
    }

}
