package com.project1.service;

import com.project1.dto.CustomerRequest;
import com.project1.dto.CustomerResponse;
import com.project1.dto.LoginRequest;
import com.project1.entity.Customer;
import com.project1.exception.CustomerNotFoundException;
import com.project1.helper.EncryptionService;
import com.project1.helper.JWTHelper;
import com.project1.mapper.CustomerMapper;
import com.project1.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;

    // FUNCTION FOR CREATING A CUSTOMER
    public String createCustomer(CustomerRequest request) {
        Customer customer = customerMapper.toCustomer(request);
        //HERE PASSWORD IS ENCODED
        customer.setPassword(encryptionService.encode(customer.getPassword()));
        customerRepo.save(customer);
        return "Customer Created Successfully";
    }

    // FUNCTION FOR GETTING CUSTOMER BY EMAIL
    public Customer getCustomer(String email) {
        return customerRepo.findByEmail(email).orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update Customer:: No customer found with the provided ID:: %s", email)
                ));
    }

    // FUNCTION FOR RETRIEVING THE CUSTOMER DETAILS FOR THE RESPONSE
    public CustomerResponse retrieveCustomer(String email) {
        Customer customer = getCustomer(email);
        return customerMapper.toCustomerResponse(customer);
    }

    // FUNCTION FOR LOGIN
    public String login(LoginRequest request) {
        Customer customer = getCustomer(request.email());
        // HERE WE ARE VALIDATING THE STORED PASSWORD WITH THE ENTERED PASSWORD
        if(!encryptionService.validates(request.password(), customer.getPassword())) {
            return "Wrong Password or Email";
        }

        return jwtHelper.generateToken(request.email());
    }

    // FUNCTION TO DELETE CUSTOMER BASED ON EMAIL
    public void deleteCustomer(String email) {
        Customer customer = getCustomer(email);
        customerRepo.delete(customer);
    }
}
