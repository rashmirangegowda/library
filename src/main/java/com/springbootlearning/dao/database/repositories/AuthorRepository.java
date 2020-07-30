package com.springbootlearning.dao.database.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springbootlearning.dao.database.entities.Author;
import com.springbootlearning.dao.database.entities.Book;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	
}
