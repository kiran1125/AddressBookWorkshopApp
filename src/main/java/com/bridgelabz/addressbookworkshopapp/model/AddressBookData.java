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

import com.bridgelabz.addressbookworkshopapp.dto.AddressBookDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AddressBookData implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aId;
    @Column
    private String addressBookName;

    @OneToMany(mappedBy = "addressBookData" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private List<PersonData> personList;

    public AddressBookData(AddressBookDTO addressBookDTO){
        this.addressBookName = addressBookDTO.getAddressBookName();
        this.personList = addressBookDTO.getPersonList();
    }

    public void updateAddressBookData(AddressBookDTO addressBookDTO) {
        this.addressBookName = addressBookDTO.getAddressBookName();
    }

}
