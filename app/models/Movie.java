package models;

import play.*;
import play.db.jpa.*;
import javax.persistence.*;
import java.util.*;
@Entity
public class Movie extends Item{

	public Movie(String title, String creator) {
		super(title, creator);
	}
}
