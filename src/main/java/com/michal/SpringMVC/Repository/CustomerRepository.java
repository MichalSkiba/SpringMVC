package com.michal.SpringMVC.Repository;

import com.michal.SpringMVC.Model.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> getAllCustomers();
}
