import org.junit.*;

import controllers.Application;

import play.test.*;
import play.mvc.*;
import play.mvc.Http.*;
import models.*;

public class ApplicationTest extends FunctionalTest {

	@Test
	public void testIndex(){
		Response response = GET("/");
		assertIsOk(response);
		assertContentType("text/html", response);
        assertCharset(play.Play.defaultWebEncoding, response);
	}
//    @Test
    public void testAddItemToList() {
        Response response = GET("/additem");
        assertIsOk(response);
    }
    
    @Test
    public void testListBook(){
    	Response response = GET("/listbook");
    	assertIsOk(response);
    }
<<<<<<< HEAD
   @Test
   public void testSearchByAuthor(){
	 Response response = GET("/searchByAuthor");
	 assertIsOk(response);
   }
   
  
=======
    
    
//    @Test
//    public void shouldGetItemByTitle(){
//    	Response response = GET("/getItem");
//    	assertIsOk(response);
//    }
    @Test
<<<<<<< HEAD
	public void shouldIssueAItem(){
    	//Application.addItemToList("Head first java", "Kent black", "Book");
		assertTrue(Application.issueItem((long)1));
		assertFalse(Application.issueItem((long)1));
	}
    
    @Test
    public void shouldReserveAItem(){
    	assertTrue(Application.reserveItem((long)1));
    	assertFalse(Application.reserveItem((long)1));
    }
    @Test
    public void shouldReturnAItem(){
    	assertTrue(Application.returnItem((long)1));
=======
    public void shouldReturnListOfBooksOfGivenTitle(){
    	Response response = GET("/searchItemByTitle");
    	assertIsOk(response);
>>>>>>> e96cff92226720cde0b6954db6ba30e4395a2cd2
    }
>>>>>>> 3751d43862048e60cffa8bf1532745cc38c248f3
}