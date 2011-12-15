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
    
    @Test
    public void shouldGetItemByTitle(){
    	Response response = GET("/getItem");
    	assertIsOk(response);
    }
}