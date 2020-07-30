package com.springbootlearning;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springbootlearning.dao.database.entities.Author;
import com.springbootlearning.dao.database.entities.Book;

@RestController
public interface AuthorController {
	//GET All
			@GetMapping(value = APIConstants.AUTHOR_URL, produces = {MediaType.APPLICATION_JSON_VALUE})
			public List<Author> getAllAuthors();
			
			
			
			//GET ONE
			@GetMapping(value = APIConstants.AUTHOR_AID_URL, produces = {MediaType.APPLICATION_JSON_VALUE})
			public Book getAuthor(@PathVariable(value = APIConstants.BOOKNAME_VARIABLE)  String authorName);
			
			 
			
			@PostMapping(value = APIConstants.AUTHOR_URL, produces = {MediaType.APPLICATION_JSON_VALUE})
			
			public String addAuthor(@RequestBody Author author);
			
			
			@PutMapping(value = APIConstants.AUTHOR_AID_URL, produces = {MediaType.APPLICATION_JSON_VALUE})
			public void addAuthor(@RequestBody Book book, @PathVariable(value = APIConstants.AUTHOR_AID_URL) int id);
			
			
		
			
			@DeleteMapping(value = APIConstants.AUTHOR_AID_URL, produces = {MediaType.APPLICATION_JSON_VALUE})
			@ResponseStatus(value = HttpStatus.NO_CONTENT)
			public void deleteBookByName(@PathVariable(value=APIConstants.AUTHOR_AID_URL) String bookName);
			
}
