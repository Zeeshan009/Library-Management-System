import org.junit.*;
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
    @Test
    public void testAddBook() {
        Response response = GET("/addbook");
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
    
    
    @Test
    public void shouldReturnListOfBooksOfGivenTitle(){
    	Response response = GET("/searchItemByTitle");
    	assertIsOk(response);
    }
>>>>>>> 3751d43862048e60cffa8bf1532745cc38c248f3
}