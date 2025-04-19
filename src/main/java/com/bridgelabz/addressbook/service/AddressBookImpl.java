package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.exception.AddressBookMissingException;
import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AddressBookImpl implements AddressBookService{

    @Autowired
    private AddressBookRepository repository;

    public List<AddressBook> getAllDetails() {
        log.info("Fetching all address book details");
        return repository.findAll();
    }

    public ResponseEntity<ResponseDTO> addDetails(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(addressBookDTO);
        repository.save(addressBook);
        ResponseDTO response = new ResponseDTO("Added Details Successfully", addressBook);
        log.info("Added address book details successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseDTO> getDetailsById(Long id){
        AddressBook addressBook = repository.findById(id).orElseThrow(()-> new AddressBookMissingException("ID not found: "+id));
        ResponseDTO response = new ResponseDTO("Details found", addressBook);
        log.info("Address book details with ID " + id + " found");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> updateDetails(Long id, AddressBookDTO addressBookDTO){
        AddressBook addressBook = repository.findById(id).orElse(null);

        if(addressBook == null){
            log.info("Address book details with ID " + id + " not found");
            ResponseDTO response = new ResponseDTO("Details not found", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        AddressBook addressBook1 = new AddressBook(addressBookDTO);
        addressBook1.setId(id);
        repository.save(addressBook1);
        ResponseDTO response = new ResponseDTO("Updated Details Successfully", addressBook1);
        log.info("Updated address book details successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteDetails(Long id){
        AddressBook addressBook = repository.findById(id).orElse(null);
        if(addressBook == null){
            log.error("Address book details with ID " + id + " not found");
            return new ResponseEntity<>("Details not found", HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
        log.info("Deleted address book details with ID " + id + " successfully");
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
