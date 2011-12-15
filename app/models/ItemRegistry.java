package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class ItemRegistry extends Model{
	private boolean isIssued;
	private boolean isReserved;	
	public ItemRegistry(){
		isIssued = false;
		isReserved = false;
	}

	public boolean isIssued() {
		return isIssued;
	}
	
	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
		this.save();
	}
	public boolean isReserved() {
		return isReserved;
	}
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
		this.save();
	}
}
