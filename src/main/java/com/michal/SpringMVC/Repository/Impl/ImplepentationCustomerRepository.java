package com.michal.SpringMVC.Repository.Impl;

import com.michal.SpringMVC.Model.Customer;
import com.michal.SpringMVC.Repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ImplepentationCustomerRepository implements CustomerRepository {

    private List<Customer> listOfCustomer = new ArrayList<Customer>();

    public ImplepentationCustomerRepository() {

        listOfCustomer.add(new Customer(1, "Allegro", "www.allegro.pl", false));
        listOfCustomer.add(new Customer(2, "OLX", "www.olx.pl", false));
        listOfCustomer.add(new Customer(3, "MS", "WWA", true));
    }

    public List<Customer> getAllCustomers() {
        return listOfCustomer;
    }
}
