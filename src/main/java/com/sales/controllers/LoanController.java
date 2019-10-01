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

import com.sales.exceptions.ExceptionLoanController;
import com.sales.exceptions.NotFoundException;
import com.sales.models.Customer;
import com.sales.models.Loan;
import com.sales.services.LoanService;
import java.util.Calendar;

@Controller
public class LoanController {
	@Autowired
	LoanService ls;
	
	@RequestMapping(value = "/showLoans", method = RequestMethod.GET)
	public String getLoans(Model model)
	{
		ArrayList<Loan> loans = (ArrayList<Loan>) ls.getAllLoans(); 
		model.addAttribute("loans", loans);
		return "allLoans";
	}
	
	@RequestMapping(value = "/newLoan", method = RequestMethod.POST)
	public String newLoansPOST(@ModelAttribute("loans") Loan loan, HttpServletRequest h, BindingResult result, Model model)
	{ 
		if(result.hasErrors())
		{
			return "newLoan";
		}
		try {
			ls.add(loan);
		}
		catch(ExceptionLoanController | NotFoundException e) {
			model.addAttribute("error", e);
			return "redirect:/loanError";
		}
		ls.save(loan);
		return "redirect:/showLoans";
	}
	
	@RequestMapping(value = "/newLoan", method = RequestMethod.GET)
	public String newLoansGET(Model model, HttpServletRequest h)
	{ 
		Loan loan = new Loan();
		model.addAttribute("loan", loan);
		return "newLoan";
	}
	
	@RequestMapping(value = "/deleteLoan", method = RequestMethod.POST)
	public String deleteLoansPOST(@ModelAttribute("loan")Loan loan, HttpServletRequest h)
	{ 
		try {
			ls.delete(loan);
		} catch (ExceptionLoanController e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/showLoans";
	}
	
	@RequestMapping(value = "/deleteLoan", method = RequestMethod.GET)
	public String deleteLoansGET(Model model, HttpServletRequest h)
	{ 
		Loan loan = new Loan();
		model.addAttribute("loan", loan);
		return "deleteLoan";
	}
}
