package com.project1.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data

// EXCEPTION FOR WHEN CUSTOMER IS NOT FOUND WITH THE ENTERED CREDENTIALS
public class CustomerNotFoundException extends RuntimeException {
    private final String msg;
}
