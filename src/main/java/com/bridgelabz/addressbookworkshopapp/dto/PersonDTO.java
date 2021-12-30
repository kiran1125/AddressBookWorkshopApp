package com.bridgelabz.addressbookworkshopapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * This class is to take the user input of these Variables or Attributes
 */
@Data
@AllArgsConstructor
public class PersonDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private long phoneNumber;
    private String email;
    private String address;
    private String city;
    private String country;
    
}
