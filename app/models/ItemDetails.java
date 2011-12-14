package models;

import play.*;
import play.db.jpa.*;
import javax.persistence.*;
import java.util.*;

@Entity
public class ItemDetails extends Model{
	
	private final Item item;
	private boolean isIssued;
	private boolean isReserved;	
	public ItemDetails(Item item){
		this.item = item;
	}
	
	public String getTitle(){
		return item.getTitle();
	}
}
