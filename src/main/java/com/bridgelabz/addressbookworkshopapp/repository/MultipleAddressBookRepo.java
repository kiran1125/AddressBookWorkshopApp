package com.bridgelabz.addressbookworkshopapp.repository;

import com.bridgelabz.addressbookworkshopapp.model.AddressBookData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultipleAddressBookRepo extends JpaRepository<AddressBookData,Integer> {
    
}
