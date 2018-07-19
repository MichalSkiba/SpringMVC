package com.michal.SpringMVC.Service.Impl;

import com.michal.SpringMVC.Model.Customer;
import com.michal.SpringMVC.Repository.CustomerRepository;
import com.michal.SpringMVC.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }
}
