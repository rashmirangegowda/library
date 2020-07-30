package com.springbootlearning;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootlearning.dao.database.entities.Book;
import com.springbootlearning.dao.database.mappers.BookDTOMapperImpl;
import com.springbootlearning.dao.database.mappers.BookDTOServiceImpl;
import com.springbootlearning.dao.database.model.BookDTO;

@RestController
public class LibraryRESTControllerImpll {

	@Autowired
	private LibraryService libraryService;
	
	@Autowired
	private BookDTOServiceImpl bookDTOServiceImpl;
	
	
	@RequestMapping("/lambdas")
	public int getlambdaoutput()
	{
		return 0;
		
	}
	
	//GET All
	@RequestMapping("/library")
	public List<BookDTO> getAllBooks()
	{
		//return libraryService.getAllBooks();
		return bookDTOServiceImpl.findAllBooks();
	}
	
	
	//GET ONE
	@RequestMapping("/library/{bookName}")

	public Book getBook(@PathVariable  String bookName)
	{
		return libraryService.getBook(bookName);
	}
	
	
	//@RequestMapping(method = RequestMethod.POST,value="/library")
	
	@PostMapping(value = "/library" , produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	
	public BookDTO addBook(@RequestBody BookDTO bookDTO)
	{
		if(bookDTO.getBookName().isEmpty())
		{
			throw new InvalidFieldException("BookName is a required Field");
			
		}
		
		//libraryService.addBook(book);
	   
	     
		return bookDTOServiceImpl.save(bookDTO);
	}
	
	@PutMapping("/library/{id}")
	public void addBook(@RequestBody Book book, @PathVariable int id)
	{
		
		libraryService.updateBook(id,book);
	}
	
	@RequestMapping("/libraryalphasorted")
	public List<Book> getSortedBooks()
	{
		
		return libraryService.getSortedBooks();
	}
	
	@DeleteMapping("/library/{bookId}")
	public void deleteBookById(@PathVariable int id)
	{
		BookDTO bookDTO = bookDTOServiceImpl.findBookbyId(id);
		Assert.notNull(bookDTO, "book Not found so cannot delete");
		bookDTOServiceImpl.delete(bookDTO);
	}
	
	
	
	     
	
	
}