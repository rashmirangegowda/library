package com.springbootlearning.dao.database.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.springbootlearning.dao.database.entities.Book;
import com.springbootlearning.dao.database.model.BookDTO;

@Component
public class BookDTOMapperImpl implements BookDTOMapper{

	private static final String BOOK_CANNOT_BE_NULL = "Book Object cannot be null";
	private static final String BOOK_DTO_CANNOT_BE_NULL = "Book DTO cannot be null";
	
	ModelMapper mapper = new ModelMapper();
	@Override
	public Book mapBookModeltoEntity(BookDTO bookDTO) {
		
		 Assert.notNull(bookDTO, BOOK_DTO_CANNOT_BE_NULL);
		return mapper.map(bookDTO, Book.class);
	}

	@Override
	public void mapBookDTOToEntity(BookDTO bookDTO, Book book) {
         
		 Assert.notNull(bookDTO, BOOK_DTO_CANNOT_BE_NULL);
		 book.setBookName(bookDTO.getBookName());
		 book.setBookIdNumber(bookDTO.getBookIdNumber());
		 book.setBookAuthor(bookDTO.getBookAuthor());
		 book.setGenre(bookDTO.getGenre());
	}

	@Override
	public BookDTO mapBookEntitytoModel(Book book) {
		return mapper.map(book, BookDTO.class);
	}

	@Override
	public void mapBookEntitytoDTO(Book book, BookDTO bookDTO) {
		Assert.notNull(book,BOOK_CANNOT_BE_NULL );
		Assert.notNull(bookDTO, BOOK_DTO_CANNOT_BE_NULL );
		bookDTO.setBookName(book.getBookName());
		bookDTO.setBookIdNumber(book.getBookIdNumber());
		bookDTO.setBookAuthor(book.getBookAuthor());
		bookDTO.setGenre(book.getGenre());
	}

}
