package com.niit.foodcourtbackend.dao;


import org.springframework.stereotype.Component;

import com.niit.foodcourtbackend.Customer;

@Component
public interface CustomerDao {

	boolean addCustomer(Customer customer);
}

