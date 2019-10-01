package com.sales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.repositories.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository cr;
	
	public List<Customer> getAllCustomers()
	{
		return (List<Customer>) cr.findAll();
	}
	
	public void save(Customer customer)
	{
		cr.save(customer);
	}
	
	public Customer findCustomerCid(Long cid)
	{
		return cr.findOne(cid);
	}
}
