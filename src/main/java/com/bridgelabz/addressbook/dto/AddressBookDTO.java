package com.bridgelabz.addressbook.dto;
import lombok.Data;
import java.util.List;

@Data
public class AddressBookDTO {

    String name;
    String address;
    String city;
    List<String> emailAddress;

    public AddressBookDTO() {
    }

    public AddressBookDTO(String name, String address, String city, List<String> emailAddress) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.emailAddress = emailAddress;
    }
}
