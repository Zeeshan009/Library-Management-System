package controllers;

import play.*;
import play.db.jpa.Model;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void listBook() {
    	List itemList = Item.find("order by id",null).fetch();
    	List itemRegistryList = ItemRegistry.find("order by id", null).fetch();
    	render(itemList,itemRegistryList);
    }
    
    
    public static void addBook(){    	
    	render();
    }

    
    public static void addItemToList(String title,String creator){
    	Item item = new Movie(title,creator).save();
    	new ItemRegistry().save();
    	addBook();
    }
    
    public static void index(){
    	render();
    }

}