package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService service;

    @RequestMapping("/")
    public String sayHello() {
        return "Welcome to Address Book Application";
    }

    @RequestMapping("/getAllDetails")
    public List<AddressBook> getAllDetails() {
        return service.getAllDetails();
    }

    @PostMapping("/addDetails")
    public ResponseEntity<ResponseDTO> addDetails(@RequestBody AddressBookDTO addressBookDTO) {
        return service.addDetails(addressBookDTO);
    }

    @GetMapping("/getDetails/{id}")
    public ResponseEntity<ResponseDTO> getDetailsById(@PathVariable Long id) {
        return service.getDetailsById(id);
    }

    @PutMapping("/updateDetails/{id}")
    public ResponseEntity<ResponseDTO> updateDetails(@PathVariable Long id, @RequestBody AddressBookDTO addressBookDTO) {
        return service.updateDetails(id, addressBookDTO);
    }

    @DeleteMapping("/deleteDetails/{id}")
    public ResponseEntity<String> deleteDetails(@PathVariable Long id){
        return service.deleteDetails(id);
    }
}
