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

	private static void inputTypeError() {
		render();
	}
}