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
	private boolean getIssueStatus()
	{
		return isIssued;
	}
	public boolean getReservedStatus()
	{
		return isReserved;
	}
}
