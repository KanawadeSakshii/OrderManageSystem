package com.example.demo.Service;

import com.example.demo.Model.Customer;

public interface CustomerService {

	public Customer createCustomer(Customer customer);
    public Customer promoteCustomer(Long customerId );
    Customer getCustomerById(Long customerId);
}
