package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemDetailsTest {

	@Test
	public void shouldCreateObject() {
		Book book = new Book("Ansci C", "Balagurusamy");
		ItemDetails itemDetail = new ItemDetails(book);
		assertNotNull(itemDetail);
	}

	@Test
	public void shouldNotCreateObjectWithNullAsArguments() {
		boolean flag = false;
		try {
			ItemDetails itemDetails = new ItemDetails(null);
		} catch (RuntimeException e) {
			flag = true;
		}
		assertTrue(flag);
	}
	
	@Test
	public void shouldGetTitle(){
		Book book = new Book("Ansci C", "Balagurusamy");
		ItemDetails itemDetail = new ItemDetails(book);
		assertEquals("Ansci C",itemDetail.getTitle());
		assertFalse(itemDetail.getTitle().equalsIgnoreCase("Ansci"));
	}
}
