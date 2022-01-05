package com.bridgelabz.addressbookworkshopapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bridgelabz.addressbookworkshopapp.dto.AddressBookDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addressbook_details")
public class AddressBookData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aId;
    @Column
    private String addressBookName;

    public AddressBookData(AddressBookDTO addressBookDTO){
        this.addressBookName = addressBookDTO.getAddressBookName();
    }

    public void updateAddressBookData(AddressBookDTO addressBookDTO) {
        this.addressBookName = addressBookDTO.getAddressBookName();
    }

}
