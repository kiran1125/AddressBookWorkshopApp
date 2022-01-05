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
    
    //Dependency Injection
    @Autowired
    private MultipleAddressBookRepo multipleAddressBookRepo;
    @Autowired
    private AddressBookRepository addressBookRepository;

    /**
	 * This method is to add AddressBook to the data base
	 * @param addressBookDTO
	 * @return addressBookdata
	 */
    @Override
    public AddressBookData addAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookDTO);
        multipleAddressBookRepo.save(addressBookData);
        return addressBookData;
    }

    /**
	 * This method is to add person data into the data base with addressbook id
	 * @param id
	 * @param personDTO
	 * @return person data
	 */
    @Override
    public PersonData addPersonDataInAddressBook(int id,PersonDTO personDTO) {
        PersonData personData = new PersonData(personDTO);
        Optional<AddressBookData> addressBookData = multipleAddressBookRepo.findById(id);
        personData.setAddressBookData(addressBookData.get());
        return addressBookRepository.save(personData);
    }

    /**
	 * This method is to get all the addressBookdata from the database
	 * @return addressBookData
	 */
    @Override
    public List<AddressBookData> getAddressBookData() {
        return multipleAddressBookRepo.findAll();
    }

    /**
	 * This method is to get the addressBookData from the database
	 * @param aId
	 * @return addressBookData
	 */
    @Override
    public AddressBookData getPersonDataFromAddressBook(int aId) {
        return multipleAddressBookRepo.findById(aId).get();
    }

    /**
	 * This method is to update the addressBookData using aId
	 * @param aId
	 * @param addressBookDTO
	 * @return addressBookData
	 */
    @Override
    public AddressBookData updateAddressBookData(int aId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getPersonDataFromAddressBook(aId);
		addressBookData.updateAddressBookData(addressBookDTO);
		return multipleAddressBookRepo.save(addressBookData);
    }

    /**
	 * This method is to delete the addressBookData
	 * @param addressbookId
	 */
    @Override
    public void deleteAddressBookData(int addressbookId) {
        AddressBookData addressBookData = this.getPersonDataFromAddressBook(addressbookId);
		multipleAddressBookRepo.delete(addressBookData);
        
    }
    
}
