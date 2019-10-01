package com.sales.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Book;
import com.sales.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bs;
	
	@RequestMapping(value = "/showBooks", method = RequestMethod.GET)
	public String getBooks(Model model)
	{
		ArrayList<Book> books = (ArrayList<Book>) bs.getAllBooks(); 
		model.addAttribute("books", books);
		return "allBooks";
	}
	
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBookPOST(@Valid  Book book, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "addBook";
		}
		else 
		{
			bs.save(book);
			return "redirect:/showBooks";
		}
	}
	
	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public String addBookGET(Model model, HttpServletRequest h)
	{
		Book book = new Book();
		model.addAttribute("book", book);
		return "addBook";
	}

}
