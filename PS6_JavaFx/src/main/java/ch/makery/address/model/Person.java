package ch.makery.address.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.Entity;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


import ch.makery.address.util.LocalDateAdapter;
import domain.PersonDomainModel;


public class Person extends PersonDomainModel {

	private PersonDomainModel personDomainModel;
    
	/*public Person() {
        this(null, null, null, (Integer)null, null, null);
    }*/

	public Person() {
		this.setPersonDomainModel();
	}
    public Person(String firstName, String lastName, String street, int postalCode, String city, Date date ) {
    	super(firstName, lastName, street, postalCode, city, date);
    	this.setPersonDomainModel();
    }
	
	 public StringProperty getLastNameProperty() {
	        return new SimpleStringProperty(super.getLastName());
	    }
	 
	 public StringProperty getFirstNameProperty() {
	        return new SimpleStringProperty(super.getFirstName());
	    }

	 private void setPersonDomainModel() {
		 this.personDomainModel = new PersonDomainModel();
	 }
	 public PersonDomainModel getPersonDomainModel() {
		 return personDomainModel;
	 }
	 
	 

}