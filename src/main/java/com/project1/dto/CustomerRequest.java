package com.project1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record CustomerRequest(
        @NotNull(message = "Customer should be present")
        @NotEmpty(message = "Customer should be present")
        @NotBlank(message = "Customer should be present")
        @JsonProperty("first_name")
        String firstName,

        @JsonProperty("last_name")
        String lastName,

        @NotNull(message="Customer email is required")
        @Email(message = "Email must be in correct format")
        @JsonProperty("email")
        String email,

        //added some additional fields like address, city and pin
        @NotNull(message = "Address is required")
        @NotEmpty(message = "Address should not be empty")
        @JsonProperty("address")
        String address,

        @NotNull(message = "City is required")
        @NotEmpty(message = "City should not be empty")
        @JsonProperty("city")
        String city,

        @NotNull(message = "Pin code is required")
        @NotEmpty(message = "Pin code should not be empty")
        @Pattern(regexp = "^[0-9]{6}$", message = "Pin code must be a 6-digit number")
        @JsonProperty("pin")
        String pin,

        @NotNull(message = "Password should be present")
        @NotEmpty(message = "Password should be present")
        @NotBlank(message = "Password should be present")
        @Size(min = 6, max = 12)
        @JsonProperty("password")
        String password
)
{}
