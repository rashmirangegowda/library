package com.springbootlearning.dao.database.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="lib_book")
public class BookNew {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookIdNumber;

	@NotBlank(message ="bookName Needed")
	@Column(name="Name", nullable = false)
	private String bookName;
	
	//@ManyToOne
	//private Author author;
	
	@Column(name="Author")
	private String bookAuthor ;
	

	@Column(name="Genre")
	String bookGenre;
	
	
	@Column(name="Price")
	Long bookPrice;
	
	LocalDate bookPublishDate;
	
	@CreationTimestamp
	@Column(name="BookAvailableFrom")
	LocalDateTime bookAddDate ;
	
	@UpdateTimestamp
	@Column(name="BookUpdatedOn")
	LocalDateTime bookUpdateDate;
	
	
	public BookNew()
	{
		super();
	}
	
	
	public BookNew(String bookName, String bookAuthor, int bookIdNumber, String genre) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookIdNumber = bookIdNumber;
		this.bookGenre = genre;
	}
	




	public String getBookGenre() {
		return bookGenre;
	}


	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}


	public LocalDateTime getBookAddDate() {
		return bookAddDate;
	}


	public void setBookAddDate(LocalDateTime bookAddDate) {
		this.bookAddDate = bookAddDate;
	}


	public LocalDateTime getBookUpdateDate() {
		return bookUpdateDate;
	}


	public void setBookUpdateDate(LocalDateTime bookUpdateDate) {
		this.bookUpdateDate = bookUpdateDate;
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
	public String getbookGenre() {
		return bookGenre;
	}
	public void setGenre(String genre) {
		this.bookGenre = genre;
	}


	public Long getBookPrice() {
		return bookPrice;
	}


	public void setBookPrice(Long bookPrice) {
		this.bookPrice = bookPrice;
	}


	public LocalDate getBookPublishDate() {
		return bookPublishDate;
	}


	public void setBookPublishDate(LocalDate bookPublishDate) {
		this.bookPublishDate = bookPublishDate;
	}
}
