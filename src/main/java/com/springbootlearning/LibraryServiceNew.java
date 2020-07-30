package com.springbootlearning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SortAdapter;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.springbootlearning.dao.database.entities.Book;
import com.springbootlearning.dao.database.mappers.BookDTOMapper;
import com.springbootlearning.dao.database.model.BookDTO;
import com.springbootlearning.dao.database.repositories.BookRepository;

@Service 
public class LibraryServiceNew {

	private List<Book> books = 	(Arrays.asList( new
			  Book("Ramayan","valmiki",123,"Mythological"), new
				 Book("Mahabharat","Vyaasa",345,"Mythological") ));;
	
	
	private BookRepository bookRepository;
	private BookDTOMapper bookDTOMapper;

	
	public LibraryServiceNew(BookRepository bookRepository,BookDTOMapper bookDTOMapper) {
		super();
		this.bookRepository = bookRepository;
		this.bookDTOMapper = bookDTOMapper;
	}
	

	
	
	
	public List<BookDTO> getAllBooks()
	{
	   List<Book> booksfromRepo = new ArrayList<>();
			   bookRepository.findAll().forEach(booksfromRepo::add);
			   
	   
		return booksfromRepo.stream().map(book -> bookDTOMapper.mapBookEntitytoModel(book)).collect(Collectors.toList()) ;
	}
	
	public void addBook(BookDTO bookDTO)
	{
		Book book = new Book();
		Assert.notNull(bookDTO, "BookDTO cannot be null when adding");
		bookDTOMapper.mapBookDTOToEntity(bookDTO,book);
		bookRepository.save(book);
	}

	public BookDTO getBook(String bookName)
	{
		BookDTO bookDTO = new BookDTO();
		Assert.isTrue(bookName.isEmpty(), "Book Name has to be provided");
	     
	    //  reqBookList = books.stream().filter(b-> b.getBookName().equalsIgnoreCase(bookName)).collect(Collectors.toList());
	     Book foundBook  = bookRepository.findBybookName(bookName);
	     bookDTOMapper.mapBookEntitytoDTO(foundBook, bookDTO);
	     return bookDTO;
	     
	     
			/*
			 * if(foundBook==null) foundBook = new Book(); else
			 * System.out.println("The book found is"+foundBook);
			 */
	    //  return foundBook;
	
		//return 
	}
	
	public void updateBook(int bookId, BookDTO bookDTO)
	{
		//Optional<Book> existingBook = bookRepository.findById(bookId);
		
	}

	public List<Book> getSortedBooks(String order) {
		
		if(order.contains("asc"))
		books = bookRepository.findAllSortedbyBookName();
		//OR we can also use
		else if (order.contains("desc"))
		books = bookRepository.findAll(Sort.by(Sort.Direction.DESC, "bookName"));
		
	      return books;
		
	}


}
