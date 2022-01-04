package com.bridgelabz.addressbookworkshopapp.dto;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.addressbookworkshopapp.model.PersonData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AddressBookDTO {
    
    private String addressBookName;
    private List<PersonData> personList = new ArrayList<>();
}
