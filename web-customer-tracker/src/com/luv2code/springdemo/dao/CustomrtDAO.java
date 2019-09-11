package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomrtDAO {

	public List<Customer> getCustomers() ;

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public Object deleteCustomer(int theId);
}
