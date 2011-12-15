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

    public static void searchItemByAuthor(){
    	render();
    }
    public static void addItemToList(String title,String creator){
    	Item item = new Movie(title,creator).save();
    	new ItemRegistry().save();
    	addBook();
    }
    public static void searchItemByAuthor1(String author){
    	List itemList=Item.find("byCreator",author).fetch();
    	List<ItemRegistry> itemRegistryList = null;
    	for(Object item:itemList){
    		itemRegistryList=ItemRegistry.find("byId",((Item)item).getId()).fetch();
    	}
    	render(itemList,itemRegistryList);
    }
    public static void index(){
    	render();
    }

}