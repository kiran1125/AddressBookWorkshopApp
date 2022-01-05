package com.bridgelabz.addressbookworkshopapp.controller;

import java.util.List;

import javax.validation.Valid;

import com.bridgelabz.addressbookworkshopapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookworkshopapp.dto.PersonDTO;
import com.bridgelabz.addressbookworkshopapp.dto.ResponseDTO;
import com.bridgelabz.addressbookworkshopapp.model.AddressBookData;
import com.bridgelabz.addressbookworkshopapp.model.PersonData;
import com.bridgelabz.addressbookworkshopapp.services.IMultipleAddressBookServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class MultipleAddressBookController {
    
    //Dependency injection
    @Autowired
    private IMultipleAddressBookServices multipleAddressBookServices;

	/**
	 * This method is to add AddressBooks to the data base
	 * @param addressBookDTO
	 * @return ResponseEntity with response and addressBookdata
	 */
    @PostMapping("/post")
	public ResponseEntity<ResponseDTO> addingPerson(@Valid @RequestBody AddressBookDTO addressBookDTO){
		AddressBookData addressBookData = multipleAddressBookServices.addAddressBookData(addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("post data is Successful", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}

	/**
	 * This method is to add person data into the data base with addressbook id
	 * @param id
	 * @param personDTO
	 * @return ResponseEntity with the person data
	 */
    @PostMapping("/add/{id}")
	public ResponseEntity<ResponseDTO> addPersonData(@PathVariable int id,@Valid @RequestBody PersonDTO personDTO){
		PersonData personData = multipleAddressBookServices.addPersonDataInAddressBook(id,personDTO);
		ResponseDTO responseDTO = new ResponseDTO("post data is Successful", personData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}

	/**
	 * This method is to get all the addressBookdata from the database
	 * @return ResponseEntity with addressBookData
	 */
    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getAddressBook(){
		List<AddressBookData> addressBookList = multipleAddressBookServices.getAddressBookData();
		ResponseDTO responseDTO = new ResponseDTO("Get call Successful", addressBookList);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}

	/**
	 * This method is to get the addressBookData from the database
	 * @param aId
	 * @return ResponseEntity with addressBookData
	 */

    @GetMapping("/get/{aId}")
    public ResponseEntity<ResponseDTO> getPersonData(@PathVariable int aId){
        AddressBookData addressBookData = multipleAddressBookServices.getPersonDataFromAddressBook(aId);
        ResponseDTO responseDTO = new ResponseDTO("Get call Successful", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

	/**
	 * This method is to update the addressBookData using aId
	 * @param aId
	 * @param addressBookDTO
	 * @return ResponseEntity with response and addressBookData
	 */
    @PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("id") int aId,@Valid @RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = null;
		addressBookData = multipleAddressBookServices.updateAddressBookData(aId,addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("created address book successfully", addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * This method is to delete the addressBookData
	 * @param addressbookId
	 * @return ResponseEntity with Id
	 */
    @DeleteMapping("/Delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("id") int addressbookId) {
		multipleAddressBookServices.deleteAddressBookData(addressbookId);
		ResponseDTO respDTO = new ResponseDTO("Deleted AddressBook data Successfully",  + addressbookId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

}

