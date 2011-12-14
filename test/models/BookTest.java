package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookTest {
	@Test
	public void shouldCreateObject(){
		Book book = new Book("Data Structures","Pai");
		assertNotNull(book);
	}
	
	@Test
	public void shouldNotCreateObjectWithEmptyArguments(){
		boolean flag = false;
		try {
			Book book = new Book("","");
		} catch (RuntimeException e) {
			flag = true;
		}
		assertTrue(flag);
	}
}
