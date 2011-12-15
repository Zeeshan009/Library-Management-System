package controllers;

import play.*;
import play.db.jpa.Model;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {


    public static void searchItemByAuthor(){
    	render();
    }

    public static void searchItemByAuthor1(String author){
    	List itemList=Item.find("byCreator",author).fetch();
    	List<ItemRegistry> itemRegistryList = null;
    	for(Object item:itemList){
    		itemRegistryList=ItemRegistry.find("byId",((Item)item).getId()).fetch();
    	}
    	render(itemList,itemRegistryList);
    }


	public static void listBook() {
		List itemList = Item.findAll();
		List itemRegistryList = ItemRegistry.findAll();
		render(itemList, itemRegistryList);
	}

	public static void addItem() {
		render();
	}

	public static void addItemToList(String title, String creator,
			String itemType) {
		if (itemType.trim().equalsIgnoreCase("Movie")) {
			new Movie(title, creator).save();
			new ItemRegistry().save();
		} else if (itemType.trim().equalsIgnoreCase("Book")) {
			new Book(title, creator).save();
			new ItemRegistry().save();
		}else{
			inputTypeError();
		}
		
		addItem();
	}

	public static void searchItemByTitle()
	{
			render();
	}
	public static void searchItemWithThisTitle(String title)
	{
		List itemListWithGivenTitle=Item.find("byTitle", title).fetch();
		List itemsInRegistry=ItemRegistry.findAll();
		List itemList=new ArrayList();
		for(Object item: itemListWithGivenTitle)
		{
			for(Object itemRegis :itemsInRegistry)
			{
				if(((Model) item).getId().equals(((Model) itemRegis).getId()))
					itemList.add(itemRegis);
			}
		}
	
		render(itemListWithGivenTitle,itemList);
	}
	public static void index() {
		render();
	}

	private static void inputTypeError(){
		render();
	}
}