package com.project1.dto;

import lombok.Data;

@Data
public class CustomerUpdateRequest {

    private String first_name;

    private String last_name;

    private String address;

    private String city;

    private String pin;
}
