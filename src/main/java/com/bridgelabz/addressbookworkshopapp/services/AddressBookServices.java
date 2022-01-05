package com.bridgelabz.addressbookworkshopapp.services;

import java.util.List;

import com.bridgelabz.addressbookworkshopapp.dto.PersonDTO;
import com.bridgelabz.addressbookworkshopapp.exceptions.AddressBookException;
import com.bridgelabz.addressbookworkshopapp.model.PersonData;
import com.bridgelabz.addressbookworkshopapp.repository.AddressBookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServices implements IAddressBookServices{

    @Autowired
    private AddressBookRepository addressBookRepository;

    /**
     * this method is to get all person data
     * @param personDTO
     * @return personData
     */
    @Override
    public List<PersonData> getPersonData() {
        return addressBookRepository.findAll();
    }
    /**
     * this method is to get the  person data by Id
     * @param personDTO
     * @param id
     * @return personData
     */

    @Override
    public PersonData getPersonDataById(int id) {
        return addressBookRepository.findById(id).orElseThrow(()-> new AddressBookException("Person not found"));
    }

    /**
     * this method is to post the person data
     * @param personDTO
     * @return personData
     */
    @Override
    public PersonData addPersonData(PersonDTO personDTO) {
        PersonData personData = new PersonData(personDTO);
        return addressBookRepository.save(personData);
    }
    /**
     * This method is to update the person data
     * @param id
     * @param personDTO
     * @return PersonData which is updated
     */
    @Override
    public PersonData updatePersonData(int id, PersonDTO personDTO) {
        PersonData personData = this.getPersonDataById(id);
        personData.updatePersonData(personDTO);
        return addressBookRepository.save(personData);
    }
    /**
     * this method is to delete the personData by using the id
     * @param id
     */
    @Override
    public void deletePersonData(int id) {
        PersonData personData = this.getPersonDataById(id);
        addressBookRepository.delete(personData); 
    }
    @Override
    public PersonData getPersonDataByIdAndAId(int aId, int pId) {
        return addressBookRepository.findByIdWithAddressBookId(aId, pId);
    }
    
}
