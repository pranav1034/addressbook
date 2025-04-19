package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {

    @Autowired
    private AddressBookService service;
}
