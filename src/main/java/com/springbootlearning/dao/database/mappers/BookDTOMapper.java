package com.springbootlearning.dao.database.mappers;

import java.util.Optional;

import com.springbootlearning.dao.database.entities.Book;
import com.springbootlearning.dao.database.model.BookDTO;

public interface BookDTOMapper {
	
	
	 Book mapBookModeltoEntity(BookDTO bookDTO);
	 
	 void mapBookDTOToEntity(BookDTO bookDTO, Book book);
	 
	 void mapBookEntitytoDTO(Book book, BookDTO bookDTO);

	BookDTO mapBookEntitytoModel(Book book);
	 

}
