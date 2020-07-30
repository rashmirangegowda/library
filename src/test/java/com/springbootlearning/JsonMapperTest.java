package com.springbootlearning;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.validation.constraints.AssertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.springbootlearning.dao.database.entities.Book;

@SpringBootTest
class JsonMapperTest {
	@Autowired
	JsonJavaObjMapper jsonMapper ;
	Book book;

	@Test
	void testJsontoObj() {
		
	}
 
}
