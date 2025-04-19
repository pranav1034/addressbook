package com.bridgelabz.addressbook.dto;
import lombok.Data;
import java.util.List;
import jakarta.validation.constraints.*;

@Data
public class AddressBookDTO {

    @NotBlank(message = "Name cannot be blank")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name must start with a capital letter and have at least 2 characters")
    String name;

    @NotBlank(message = "Address cannot be blank")
    String address;

    @NotBlank(message = "City cannot be blank")
    String city;


    List<@NotBlank(message = "Email address cannot be blank") @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format") String> emailAddress;

    public AddressBookDTO() {
    }

    public AddressBookDTO(String name, String address, String city, List<String> emailAddress) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.emailAddress = emailAddress;
    }
}
