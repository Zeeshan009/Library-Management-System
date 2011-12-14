package models;

import javax.persistence.Entity;

import play.db.jpa.Model;


@Entity
public class ItemDetails extends Model{
	
	private final Item item;
	private boolean isIssued;
	private boolean isReserved;
	public ItemDetails(Item item){
		this.item = item;
		isIssued = false;
		isReserved = false;
	}
	
	public String getTitle(){
		return item.getTitle();
	}
}
