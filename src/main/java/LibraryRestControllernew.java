package com.springbootlearning;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootlearning.dao.database.entities.Book;
import com.springbootlearning.dao.database.model.BookDTO;

@RestController
public class LibraryRESTControllerImpll implements LibraryRestController{

	private LibraryService libraryService;
	
	@Autowired
	public LibraryRESTControllerImpll(LibraryService libraryService) {
		super();
		this.libraryService = libraryService;
	}
	
	@RequestMapping("/lambdas")
	public int getlambdaoutput()
	{
		return 0;
		
	}
	
	//GET All
      @Override
	public List<BookDTO> getAllBooks()
	{
		return libraryService.getAllBooks();
	}
	
	


	//GET ONE
      @Override
	public BookDTO getBook(String bookName)
	{
		return libraryService.getBook(bookName);
	}
	
	
	@RequestMapping(method = RequestMethod.POST,value="/library/book")
	
    	
	public String addBook(@RequestBody BookDTO book)
	{
    	 
		if(book.getBookName().isEmpty())
		{
			throw new InvalidFieldException("BookName is a required Field");
			
		}
		
		libraryService.addBook(book);
		return("Book Added Successfully");
	}
	
      @Override
	public void addBook(BookDTO book, int id)
	{
		
		libraryService.updateBook(id,book);
	}
	
	@RequestMapping("/libraryalphasorted")
	public List<Book> getSortedBooks(@RequestParam("order") String order)
	{
		
		return libraryService.getSortedBooks(order);
	}
	
	 @Override
	public void deleteBookByName(String bookName)
	{
		
	}
	{ 
		
	}
	
	
	     
	
	
}
