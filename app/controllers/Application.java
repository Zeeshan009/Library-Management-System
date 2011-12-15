package controllers;

import play.*;
import play.db.jpa.Model;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

	public static void listBook() {
		List itemList = Item.find("order by id", null).fetch();
		List itemRegistryList = ItemRegistry.find("order by id", null).fetch();
		render(itemList, itemRegistryList);
	}

	public static void addItem() {
		render();
	}

	public static void addItemToList(String title, String creator,
			String itemType) {
		if (itemType.trim().equalsIgnoreCase("Movie")) {
			new Movie(title, creator).save();
		} else if (itemType.trim().equalsIgnoreCase("Book")) {
			new Book(title, creator).save();
		}
		new ItemRegistry().save();
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

}