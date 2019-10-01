package com.sales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Book;
import com.sales.models.Customer;
import com.sales.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository br;
	
	public Iterable<Book> getAllBooks() {
		return  br.findAll();
	}
	
	public void save(Book book)
	{
		br.save(book);
	}
	
	public Book getBookbid(Long cid)
	{
		return br.findOne(cid);
	}
}
