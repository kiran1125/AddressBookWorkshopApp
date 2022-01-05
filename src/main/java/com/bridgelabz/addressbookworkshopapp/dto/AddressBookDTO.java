package com.bridgelabz.addressbookworkshopapp.dto;


import javax.validation.constraints.Pattern;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AddressBookDTO {
    
    @Pattern(regexp = "^[a-zA-Z]{1,}" , message = "addressBookName is invalid")
    private String addressBookName;

    //private List<PersonData> personList = new ArrayList<>();
}
