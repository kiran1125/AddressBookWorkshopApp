package com.bridgelabz.addressbookworkshopapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class is give the response 
 * in this particular format
 */

@Data
@AllArgsConstructor
public class ResponseDTO {
    private String message;
    private Object data;
  
}
