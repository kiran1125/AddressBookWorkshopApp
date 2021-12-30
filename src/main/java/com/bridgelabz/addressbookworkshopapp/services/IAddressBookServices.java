package com.bridgelabz.addressbookworkshopapp.services;

import java.util.List;

import com.bridgelabz.addressbookworkshopapp.dto.PersonDTO;
import com.bridgelabz.addressbookworkshopapp.model.PersonData;

public interface IAddressBookServices {

    List<PersonData> getPersonData();

    PersonData getPersonDataById(int id);

    PersonData addPersonData(PersonDTO personDTO);

    PersonData updatePersonData(int id, PersonDTO personDTO);

    void deletePersonData(int id);
    
}
