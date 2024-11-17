package com.project1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequest(
    @NotNull(message = "Product name is required")
    @NotBlank(message = "Product name cannot be blank")
    @JsonProperty("name")
    String name,


    @NotNull(message = "Product price is required")
    @JsonProperty("price")
    double price
){
}


