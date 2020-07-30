package com.springbootlearning.dao.database.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springbootlearning.dao.database.entities.Book;


public interface BookRepositoryNew extends JpaRepository<Book, Integer> {

	/*
	 * Book findBybookName(String bookName);
	 * 
	 * List<Book> findBybookAuthor(String bookAuthor);
	 * 
	 * //Book findBybookNameAndbookAuthor(String bookName, String Author);
	 * 
	 * //List<Book> findBybookNameORbookAuthor(String bookName, String Author);
	 * 
	 * //Finds all books whose genre is not the one that is passed List<Book>
	 * findBybookGenreNot(String genre);
	 * 
	 * //to find by field which contains a STring, while passing string it should be
	 * like %Java or Java%
	 * 
	 * List<Book> findBybookNameLike(String bookNamesubString);
	 * 
	 * //To filter out all Objects that have the parameter value that contains this
	 * subString
	 * 
	 * List<Book> findBybookNameNotLike(String filterString);
	 * 
	 * // A substitute for LIKE
	 * 
	 * List<Book> findBybookNameStartingWith(String startString);
	 * 
	 * List<Book> findBybookNameEndingWith(String endString);
	 * 
	 * List<Book> findBybookPriceLessThanEqual(Long cutoffPrice);
	 * 
	 * List<Book> findBybookPriceGreaterThanEqual(Long minPrice);
	 * 
	 * //Performing Date comparison List<Book> findBybookPublishDateBefore(Date
	 * startDate);
	 * 
	 * 
	 * List<Book> findBybookPublishDateAfter(Date startDate);
	 * 
	 * List<Book> bookPublishDateBetween(Date startDate, Date endDate);
	 * 
	 * @Query("From Book order by bookName") List<Book> findAllSortedbyBookName();
	 */
}
