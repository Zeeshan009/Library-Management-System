package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovieTest {

	@Test
	public void shouldCreateObject(){
		Movie movie = new Movie("Data Structures","Pai");
		assertNotNull(movie);
	}
	
	@Test
	public void shouldNotCreateObjectWithEmptyArguments(){
		boolean flag = false;
		try {
			Movie movie = new Movie("","");
		} catch (RuntimeException e) {
			flag = true;
		}
		assertTrue(flag);
	}}
