package com.bridgelabz.addressbookworkshopapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.addressbookworkshopapp.dto.PersonDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * This class is a Model 
 * which is used to store data in the repository
 */
@Entity
@Table(name = "addressbook_data")
@AllArgsConstructor
@NoArgsConstructor
public @Data class PersonData {

    //Attributes or properties for the Person
    @Id
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String gender;
    @Column
    private long phoneNumber;
    @Column
    private String email;
    @Column
    private String address;
    @Column
    private String city;
    @Column
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
