package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressBookImpl implements AddressBookService{

    @Autowired
    private AddressBookRepository repository;
}
