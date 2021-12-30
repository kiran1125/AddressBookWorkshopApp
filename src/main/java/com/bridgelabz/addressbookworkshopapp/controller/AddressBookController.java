package com.bridgelabz.addressbookworkshopapp.controller;

import java.util.List;

import com.bridgelabz.addressbookworkshopapp.dto.PersonDTO;
import com.bridgelabz.addressbookworkshopapp.dto.ResponseDTO;
import com.bridgelabz.addressbookworkshopapp.model.PersonData;
import com.bridgelabz.addressbookworkshopapp.services.IAddressBookServices;

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


/**
 * This class is a Controller Class 
 * which accepts all the client request with given URLs
 */
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookServices addressBookServices;
    /**
     * This method is get all data
     * @return ResponseEntity : with person data list and Status code
     */
    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getAddressBook(){
		List<PersonData> personList = addressBookServices.getPersonData();
		ResponseDTO responseDTO = new ResponseDTO("Get call Successful", personList);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
    /**
     * This method is to get data by Id
     * @param id
     * @param personDTO
     * @return ResponseEntity : with person data and Status code
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getAddressBookById(@PathVariable("id") int id){
		PersonData personData = addressBookServices.getPersonDataById(id);
		ResponseDTO responseDTO = new ResponseDTO("Get data By Id is Successfull", personData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}

    /**
     * This method is to add the data or post the data
     * @param personDTO
     * @return ResponseEntity : with person data and Status code
     */
    @PostMapping("/post")
	public ResponseEntity<ResponseDTO> addingPerson(@RequestBody PersonDTO personDTO){
		PersonData personData = addressBookServices.addPersonData(personDTO);
		ResponseDTO responseDTO = new ResponseDTO("post data is Successful", personData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}

     /**
      * This method is to update the person data
      * @param id
      * @param personDTO
      * @return ResponseEntity : with person data and Status code
      */
    @PutMapping("/put/{id}")
	public ResponseEntity<ResponseDTO> updatingPerson(@PathVariable("id") int id,@RequestBody PersonDTO personDTO){
		
		PersonData personData = addressBookServices.updatePersonData(id,personDTO);
		ResponseDTO responseDTO = new ResponseDTO("update data is Successful", personData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
    /**
     * this method is to delete the person data
     * @param id
     * @return RespResponseEntity : with messasge and Status code
     */
    @DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deletePersonById(@PathVariable ("id") int id){
		addressBookServices.deletePersonData(id);
		ResponseDTO responseDTO = new ResponseDTO("delete data is Successful of id :", id);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}




    
}
