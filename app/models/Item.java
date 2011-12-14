package models;

import play.*;
import play.db.jpa.*;
import javax.persistence.*;
import java.util.*;

public class Item extends Model{
	private final String title;
	private final String creator;

	public Item(String title, String creator){
		if(title == null || title.isEmpty() || creator == null || creator.isEmpty()){
			throw new RuntimeException();
		}
		this.title = title;
		this.creator = creator;
	}
	
	public String getTitle(){
		return title;
	}
}
