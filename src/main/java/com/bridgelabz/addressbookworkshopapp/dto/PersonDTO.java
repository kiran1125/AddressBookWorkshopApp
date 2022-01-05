package com.bridgelabz.addressbookworkshopapp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * This class is to take the user input of these Variables or Attributes
 */
@Data
@AllArgsConstructor
public class PersonDTO {
    @Min(value = 1 , message = "should not be lesser than 1")
    private int id;
    
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$",message = "First name is Invalid")
    private String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$",message = "Second name is Invalid")
    private String lastName;

    @Pattern(regexp = "male|female" , message = "gender is invalid")
    private String gender;

    @Pattern(regexp = "^[0-9]{10}" , message = "phoneNumber not valid")
    private String phoneNumber;
    
    @Email
    private String email;
    
    @NotNull
    private String address;
    
    @NotNull
    private String city;
    
    @NotNull
    private String country;
    
}
