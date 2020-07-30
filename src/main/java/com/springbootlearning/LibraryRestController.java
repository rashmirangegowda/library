package com.springbootlearning;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springbootlearning.dao.database.entities.Book;
import com.springbootlearning.dao.database.model.BookDTO;

@RestController
public interface LibraryRestController {

	
	//GET All
		@GetMapping(value = APIConstants.BOOK_URL, produces = {MediaType.APPLICATION_JSON_VALUE})
		public List<BookDTO> getAllBooks();
		
		
		
		//GET ONE
		@GetMapping(value = APIConstants.BOOK_BNAME_URL, produces = {MediaType.APPLICATION_JSON_VALUE})
		public BookDTO getBook(@PathVariable(value = APIConstants.BOOKNAME_VARIABLE)  String bookName);
		
		 
		
		@PostMapping(value = APIConstants.BOOK_URL, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE} )
		
		public String addBook(@RequestBody BookDTO bookDTO);
		
		
		@PutMapping(value = APIConstants.BOOK_BID__URL, produces = {MediaType.APPLICATION_JSON_VALUE})
		public void addBook(@RequestBody BookDTO bookDTO, @PathVariable(value = APIConstants.BOOKID_VARIABLE) int id);
		
		
		@RequestMapping("/libraryalphasorted")
		public List<Book> getSortedBooks(String order);
		
		
		@DeleteMapping("/library/{bookName}")
		@ResponseStatus(value = HttpStatus.NO_CONTENT)
		public void deleteBookByName(@PathVariable(value=APIConstants.BOOKNAME_VARIABLE) String bookName);
		
}
