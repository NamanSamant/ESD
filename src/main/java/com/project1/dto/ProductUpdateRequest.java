package com.project1.dto;

import lombok.Data;

@Data
public class ProductUpdateRequest {
    private String name;

    private double price;
}
