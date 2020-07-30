package com.springbootlearning.dao.database.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;


import com.springbootlearning.dao.database.entities.Book;
import com.springbootlearning.dao.database.model.BookDTO;
import com.springbootlearning.dao.database.repositories.BookRepository;


@Component
public class BookDTOServiceImpl {
	
	private BookRepository bookRepository;
	private BookDTOMapper bookDTOMapper;
	public BookDTOServiceImpl(BookRepository bookRepository, BookDTOMapper bookDTOMapper) {
		super();
		this.bookRepository = bookRepository;
		this.bookDTOMapper = bookDTOMapper;
	}
	
	public BookDTO save(BookDTO bookDTO)
	{
		Book book = bookDTOMapper.mapBookModeltoEntity(bookDTO);
		bookRepository.save(book);
		bookDTOMapper.mapBookEntitytoDTO(book, bookDTO);
		return bookDTO;
	}
	
	@Cacheable(value = "books-cache", key ="'BookCache+#bookId")
	public List<BookDTO> findAllBooks()
	{
		return bookRepository.findAll().stream().map(book->bookDTOMapper.mapBookEntitytoModel(book)).collect(Collectors.toList());
		
	}
	
	public BookDTO findBookbyId(int id)
	{
		Book book = bookRepository.findById(id);
		BookDTO bookDTO = null;
		if(book != null)
		{
			bookDTO = bookDTOMapper.mapBookEntitytoModel(book);
		}
		
		return bookDTO;
	}
	public void delete(BookDTO bookDTO)
	{
		Book book = bookDTOMapper.mapBookModeltoEntity(bookDTO);
		bookRepository.delete(book);
	}



}
