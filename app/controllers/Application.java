package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

	public static ItemDetails itemDetails;
    public static void index() {
    	List itemList = ItemDetails.find("order by id desc", null).fetch();
    	render(itemList);
    }
    
    public static void addBook(){
    	
    	render();
    }
    public static void addBookToList(String title,String creator){
    	Book book = new Book(title,creator);
    	itemDetails = new ItemDetails(book).save();
    	index();
    }
}