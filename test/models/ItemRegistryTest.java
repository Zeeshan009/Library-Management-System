package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemRegistryTest {

	@Test
	public void shouldCreateObject() {
		ItemRegistry itemRegistry = new ItemRegistry();
		assertNotNull(itemRegistry);
	}
	
//	@Test
//	public void shouldChangeIsIssuedStatus(){
//		ItemRegistry itemRegistry = new ItemRegistry();
//		assertFalse(itemRegistry.isIssued());
//		itemRegistry.setIssued(true);
//		assertTrue(itemRegistry.isIssued());
//		
//	}
	
}
