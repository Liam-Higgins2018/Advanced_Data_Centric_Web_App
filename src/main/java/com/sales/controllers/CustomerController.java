package com.sales.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Customer;
import com.sales.services.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	CustomerService cs;
	
	@RequestMapping(value = "/showCustomers", method = RequestMethod.GET)
	public String getCustomers(Model model)
	{
		ArrayList<Customer> customers = (ArrayList<Customer>) cs.getAllCustomers(); 
		model.addAttribute("customers", customers);
		return "allCustomers";
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String addCustomersPOST(@Valid Customer customer, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "addCustomer";
		}
		else {
			cs.save(customer);
			return "redirect:/showCustomers";
		}
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public String addCustomersGet(Model model)
	{
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "addCustomer";
	}

}
