package com.springbootlearning.dao.database.model;

import org.springframework.validation.annotation.Validated;

@Validated
public class BookDTO {
	
	int bookIdNumber;
	String bookName;
	String bookAuthor;
	String genre;
	
	public BookDTO()
	{
		super();
	}
	
	
	public BookDTO(String bookName, String bookAuthor, int bookIdNumber, String genre) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookIdNumber = bookIdNumber;
		this.genre = genre;
	}
	
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public int getBookIdNumber() {
		return bookIdNumber;
	}
	public void setBookIdNumber(int bookIdNumber) {
		this.bookIdNumber = bookIdNumber;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

}
