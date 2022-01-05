package com.bridgelabz.addressbookworkshopapp.services;

import java.util.List;

import com.bridgelabz.addressbookworkshopapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookworkshopapp.dto.PersonDTO;
import com.bridgelabz.addressbookworkshopapp.model.AddressBookData;
import com.bridgelabz.addressbookworkshopapp.model.PersonData;

public interface IMultipleAddressBookServices {

    AddressBookData addAddressBookData(AddressBookDTO addressBookDTO);
    
    PersonData addPersonDataInAddressBook(int id,PersonDTO personDTO);

    List<AddressBookData> getAddressBookData();

    AddressBookData getPersonDataFromAddressBook(int aId);

    AddressBookData updateAddressBookData(int aId, AddressBookDTO addressBookDTO);

    void deleteAddressBookData(int addressbookId);
}
