package com.springbootlearning;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.springbootlearning.dao.database.entities.Book;

@SpringBootTest
class LibraryApplicationTests {
	
	private LibraryService libservice;
	private LibraryService emptylibservice;
	
	@Test
	void contextLoads() {
	}
	
	@BeforeEach
	public  void init()
	{
		//libservice = new LibraryService();
		
	}
	
	@Test
	@DisplayName("Add new Book Test")
	public void addBookTest()
	{
		Book book = new Book( "somebook","someauthor",256,"somegenre");
		libservice.addBook(book);
		Book addedBook = libservice.getBook("somebook");
	 //  assertThat(addedBook.getBookName())
	 //     .isEqualTo(book.bookName);
		assertAll(
				()->assertThat(addedBook.getBookName())
				      .isEqualTo(book.bookName),
				()-> assertThat(addedBook.getBookAuthor())
			      .isEqualTo(book.bookAuthor)
				);
		
	}
	
	@Test
	public void exceptionTest()
	{
		assertThrows(NullPointerException.class,()-> emptylibservice.getAllBooks());
	}
		
	

}
