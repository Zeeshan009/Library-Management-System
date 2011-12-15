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
<<<<<<< HEAD
	public boolean isIssued()
	{
		return isIssued;
	}
=======
	private boolean getIssueStatus()
	{
		return isIssued;
	}
	public boolean getReservedStatus()
	{
		return isReserved;
	}
>>>>>>> 3751d43862048e60cffa8bf1532745cc38c248f3
}
