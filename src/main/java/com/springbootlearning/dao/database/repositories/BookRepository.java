package com.springbootlearning.dao.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springbootlearning.dao.database.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	List<Book> findAll();
	
	Book findById(int id);

	Book findBybookName(String bookName);
	
	List<Book> findBybookAuthor(String bookAuthor);
	
	@Query("From Book order by bookName")
	List<Book> findAllSortedbyBookName();

}
