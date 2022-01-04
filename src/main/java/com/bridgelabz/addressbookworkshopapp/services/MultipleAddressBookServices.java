package com.bridgelabz.addressbookworkshopapp.services;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.addressbookworkshopapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookworkshopapp.dto.PersonDTO;
import com.bridgelabz.addressbookworkshopapp.model.AddressBookData;
import com.bridgelabz.addressbookworkshopapp.model.PersonData;
import com.bridgelabz.addressbookworkshopapp.repository.AddressBookRepository;
import com.bridgelabz.addressbookworkshopapp.repository.MultipleAddressBookRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultipleAddressBookServices implements IMultipleAddressBookServices {

    @Autowired
    private MultipleAddressBookRepo multipleAddressBookRepo;
    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public AddressBookData addAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookDTO);
        multipleAddressBookRepo.save(addressBookData);
        return addressBookData;
    }

    @Override
    public PersonData addPersonDataInAddressBook(int id,PersonDTO personDTO) {
        PersonData personData = new PersonData(personDTO);
        Optional<AddressBookData> addressBookData = multipleAddressBookRepo.findById(id);
        personData.setAddressBookData(addressBookData.get());
        return addressBookRepository.save(personData);
    }

    @Override
    public List<AddressBookData> getAddressBookData() {
        return multipleAddressBookRepo.findAll();
    }

    @Override
    public AddressBookData getPersonDataFromAddressBook(int aId) {
        return multipleAddressBookRepo.findById(aId).get();
    }

    @Override
    public AddressBookData updateAddressBookData(int aId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getPersonDataFromAddressBook(aId);
		addressBookData.updateAddressBookData(addressBookDTO);
		return multipleAddressBookRepo.save(addressBookData);
    }

    @Override
    public void deleteAddressBookData(int addressbookId) {
        AddressBookData addressBookData = this.getPersonDataFromAddressBook(addressbookId);
		multipleAddressBookRepo.delete(addressBookData);
        
    }
    
}
