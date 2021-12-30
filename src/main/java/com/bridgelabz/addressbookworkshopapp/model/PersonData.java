package com.bridgelabz.addressbookworkshopapp.model;

import com.bridgelabz.addressbookworkshopapp.dto.PersonDTO;

import lombok.Data;


/**
 * This class is a Model 
 * which is used to store data in the repository
 */
public @Data class PersonData {

    //Attributes or properties for the Person
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private long phoneNumber;
    private String email;
    private String address;
    private String city;
    private String country;

    /**
     * This method is to Assign the data
     * @param personDTO
     */

    public PersonData(PersonDTO personDTO){
        this.id = personDTO.getId();
        this.firstName = personDTO.getFirstName();
        this.lastName = personDTO.getLastName();
        this.gender = personDTO.getGender();
        this.phoneNumber = personDTO.getPhoneNumber();
        this.email = personDTO.getEmail();
        this.address = personDTO.getAddress();
        this.city = personDTO.getCity();
        this.country = personDTO.getCountry();
    }

    public void updatePersonData(PersonDTO personDTO) {
        this.firstName = personDTO.getFirstName();
        this.lastName = personDTO.getLastName();
        this.gender = personDTO.getGender();
        this.phoneNumber = personDTO.getPhoneNumber();
        this.email = personDTO.getEmail();
        this.address = personDTO.getAddress();
        this.city = personDTO.getCity();
        this.country = personDTO.getCountry();
    }
    
}
