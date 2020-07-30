package com.springbootlearning.dao.database.entities;



import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Book {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	int bookIdNumber;
	
	
	@NotBlank(message ="bookName Needed")
	String bookName;
	
	
	String bookAuthor;

	String genre;
	
	public Book()
	{
		super();
	}
	
	
	public Book(String bookName, String bookAuthor, int bookIdNumber, String genre) {
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
