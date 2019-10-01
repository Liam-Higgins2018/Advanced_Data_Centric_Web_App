package com.sales.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.exceptions.ExceptionLoanController;
import com.sales.exceptions.NotFoundException;
import com.sales.models.Book;
import com.sales.models.Customer;
import com.sales.models.Loan;
import com.sales.repositories.LoanRepository;

@Service
public class LoanService {
	@Autowired
	LoanRepository lr;
    @Autowired
    CustomerService cs;
    @Autowired
    BookService bs;
    @Autowired
    LoanService ls;
	
    private Book book;
    private Customer customer;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
	
	public Iterable<Loan> getAllLoans()
	{
		return lr.findAll();
	}
	
	public Loan getLoanlid(long lid) 
	{
	   	 return lr.findOne(lid);
	}
	
	public void save(Loan loan)
	{
		lr.save(loan);
	}
	
	 public void delete(Loan loan) throws ExceptionLoanController {
	   	 Loan thisloan = ls.getLoanlid(loan.getLid());
	   	 if (thisloan == null) {
	   		 throw new ExceptionLoanController("No such loan: " + loan.getLid());
	   	 }
	   	 lr.delete(loan);

	    }
	
	public void add(Loan loan) throws ExceptionLoanController, NotFoundException
	{
		customer = cs.findCustomerCid(loan.getCust().getcId());
		book = bs.getBookbid(loan.getBook().getBid());
		
	   	 if (customer == null || book == null) {
	   		 throw new NotFoundException(
	   				 "No such Customer: " + loan.getCust().getcId() + " No such Book: " + loan.getBook().getBid());
	   	 }
	   	 
	   	 LocalDate dueDate = LocalDate.now().plusDays(customer.getLoanPeriod());
	   	 loan.setDueDate(dueDate.toString());

	   	 // Throw exception if the book is already on out loan(exceptions.LoanException)
	   	 try {
	   		 lr.save(loan);
	   	 } catch (Exception e) {
	   		 throw new ExceptionLoanController("Book: " + " " + loan.getBook().getBid() + book.getTitle()
	   				 + " is already on loan to customer: " + loan.getCust().getcId() + " (" + customer.getcName() + ")");
	   	 }

	}
}