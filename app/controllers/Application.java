package controllers;

import play.*;
import play.db.jpa.Model;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

	public static void searchItemByAuthor() {
		render();
	}

	public static void searchItemByAuthorResult(String author) {
		List itemList = Item.find("byCreator", author).fetch();
		List itemRegistryList = new ArrayList();
		for (Object item : itemList) {
			itemRegistryList.add(ItemRegistry.findById(((Model) item).getId()));
		}
		render(itemList, itemRegistryList);
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
		} else {
			inputTypeError();
		}

		addItem();
	}

	public static void searchItemByTitle() {
		render();
	}

	public static void searchItemWithThisTitle(String title) {
		List itemListWithGivenTitle = Item.find("byTitle", title).fetch();
		List itemRegistryList = new ArrayList();
		for (Object item : itemListWithGivenTitle) {
			itemRegistryList.add(ItemRegistry.findById(((Model) item).getId()));
		}
		render(itemListWithGivenTitle, itemRegistryList);
	}

	public static void index() {
		render();
	}

	public static void issueItem(String itemId) {
		boolean issueResult = false;
		ItemRegistry itemList = ItemRegistry.findById((long) Integer
				.parseInt(itemId));
		if (!itemList.isIssued()) {
			if (itemList.isReserved()) {
				itemList.setReserved(false);
			}
			itemList.setIssued(true);
			itemList.save();
			issueResult = true;
			render(issueResult);
		}
		render(issueResult);
	}

	public static void returnItem(String itemId) {
		boolean returnResult = false;
		ItemRegistry itemList = ItemRegistry.findById((long) Integer
				.parseInt(itemId));
		itemList.setIssued(false);
		itemList.save();
		returnResult = true;
		render(returnResult);
	}

	public static boolean reserveItem(String itemId) {
		ItemRegistry itemList = ItemRegistry.findById((long) Integer
				.parseInt(itemId));
		if (itemList.isIssued() && !itemList.isReserved()) {
			itemList.setReserved(true);
			itemList.save();
			return true;
		}
		return false;
	}

	private static void inputTypeError() {
		render();
	}

	public static void issueBook() {
		render();
	}
}