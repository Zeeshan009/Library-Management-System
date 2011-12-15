package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemRegistryTest {

	@Test
	public void shouldCreateObject() {
		ItemRegistry itemRegistry = new ItemRegistry();
		assertNotNull(itemRegistry);
	}
}
