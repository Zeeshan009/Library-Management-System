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

	public static void index() {
		render();
	}

	public static boolean issueItem(long i) {
		ItemRegistry itemList = ItemRegistry.findById((long) 1);
		if (!itemList.isIssued()) {
			if(itemList.isReserved()){
				itemList.setReserved(false);
			}
			itemList.setIssued(true);
			itemList.save();
			return true;
		}
		return false;
	}

	public static boolean returnItem(long i) {
		ItemRegistry itemList=ItemRegistry.findById((long)1);
		if(itemList.isIssued())
		{
			itemList.setIssued(false);
			itemList.save();
			return true;
		}
		return false;
	}

	public static boolean reserveItem(long i) {
		ItemRegistry itemList=ItemRegistry.findById((long)1);
		if(itemList.isIssued()&&!itemList.isReserved()){
			itemList.setReserved(true);
			itemList.save();
			return true;
		}
		return false;
	}
}