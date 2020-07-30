package com.springbootlearning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootlearning.dao.database.entities.Book;
import com.springbootlearning.dao.database.model.BookDTO;
import com.springbootlearning.dao.database.repositories.BookRepository;

@Service 
public class LibraryService {

	private List<BookDTO> books = 	 new ArrayList<>(Arrays.asList( new
			  BookDTO("Ramayan","valmiki",123,"Mythological"), new
				 BookDTO("Mahabharat","Vyaasa",345,"Mythological") ));;
	
	
	private BookRepository bookRepository;
    
	public LibraryService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
	

	
	
	
	public List<BookDTO> getAllBooks()
	{
	  // List<Book> booksfromRepo = new ArrayList<>();
			   
	  // bookRepository.findAll().forEach(booksfromRepo::add);
	  
		//return booksfromRepo;
		return books;
	}
	
	public void addBook(BookDTO book)
	{
		//bookRepository.save(book);
		books.add(book);
	}

	public Book getBook(String bookName)
	{
		
	     Book foundBook;
	    //  reqBookList = books.stream().filter(b-> b.getBookName().equalsIgnoreCase(bookName)).collect(Collectors.toList());
	      foundBook  = bookRepository.findBybookName(bookName);
	     if(foundBook.equals(null))
	    	 foundBook = new Book();
	     else
	    	 System.out.println("The book found is"+foundBook);
		 
	      return foundBook;
	
		//return 
	}
	
	public void updateBook(int bookId, Book book)
	{
		/*
		 * for (int i = 0; i < books.size(); i++) { if (books.get(i).getBookIdNumber()
		 * == bookId) { books.set(i, book); } }
		 */
	}

	public List<Book> getSortedBooks() {
		/*
		 * books = bookRepository.findAllSortedbyBookName(); if(books.isEmpty()) books =
		 * new ArrayList<>(); else System.out.println("The book found is"+books);
		 * 
		 * return books;
		 */
		return null;
		
	}


}
