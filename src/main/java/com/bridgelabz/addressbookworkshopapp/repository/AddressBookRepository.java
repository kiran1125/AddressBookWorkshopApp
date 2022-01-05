package com.bridgelabz.addressbookworkshopapp.repository;

import java.util.List;

import com.bridgelabz.addressbookworkshopapp.model.PersonData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<PersonData,Integer> {
    
    @Query(value = "select * from person_details where ab_id=?1 and id=?2",nativeQuery = true)
    PersonData findByIdWithAddressBookId(int aId,int pId);
}
