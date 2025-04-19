package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String address;
    private String city;

    @ElementCollection
    @CollectionTable(name = "user_emails",joinColumns = @JoinColumn(name = "id"))
    @Column(name = "email")
    private List<String> emailAddress;

    public AddressBook() {
    }

//    public AddressBook(Long id, String name, String address, String city, List<String> emailAddress) {
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        this.city = city;
//        this.emailAddress = emailAddress;
//    }

    public AddressBook(AddressBookDTO addressBookDTO) {
        this.name = addressBookDTO.getName();
        this.address = addressBookDTO.getAddress();
        this.city = addressBookDTO.getCity();
        this.emailAddress = addressBookDTO.getEmailAddress();
    }
}
