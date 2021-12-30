package com.bridgelabz.addressbookworkshopapp.repository;

import com.bridgelabz.addressbookworkshopapp.model.PersonData;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<PersonData,Integer> {
    
}
