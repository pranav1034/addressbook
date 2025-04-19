package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AddressBookService {

    public abstract ResponseEntity<ResponseDTO> addDetails(AddressBookDTO addressBookDTO);

    public abstract List<AddressBook> getAllDetails();

    public abstract ResponseEntity<ResponseDTO> getDetailsById(Long id);

    public abstract ResponseEntity<ResponseDTO> updateDetails(Long id, AddressBookDTO addressBookDTO);

    public abstract ResponseEntity<String> deleteDetails(Long id);
}
