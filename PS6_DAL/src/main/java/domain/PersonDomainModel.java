package domain;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import util.LocalDateAdapter;

public class PersonDomainModel {

    private  String firstName;
    private  String lastName;
    private  String street;
    private  int postalCode;
    private  String city;
    private  Date birthday;
    private  UUID personID;
   
    /**
     * Default constructor.
     */
    public PersonDomainModel() {
    	this.setPersonID(UUID.randomUUID());
    }
    public PersonDomainModel(String firstName, String lastName, String street, int postalCode, String city, Date date ) {
        
    	this.setFirstName(firstName);
        this.setLastName(lastName);
        // Some initial dummy data, just for convenient testing.
        this.setStreet(street);
        this.setPostalCode(postalCode);
        this.setCity(city);
        this.setBirthday(date);
        this.setPersonID(UUID.randomUUID());
    }

    public String getFirstName() {
        return firstName;
    }

  
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        
        
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String LastName) {
    	this.lastName = LastName;
    }
    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode.intValue();
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getBirthday() {
    	return this.birthday;
    }
    
    public void setBirthday(Date birthday) {
    	this.birthday = birthday;
    }
    
    
    public static LocalDate getLocalDOB(Date date) {
    	Instant instant = Instant.ofEpochMilli(date.getTime());
    	LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
    	System.out.println("localDate: " + localDate.toString());
    	
    	//LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }
    
    public Date getDOBfromLocalDate(LocalDate date) {
    	Date newDate = Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    	return newDate;
    }
  
	public UUID getPersonID() {
		return personID;
	}

	public void setPersonID(UUID personID) {
		this.personID = personID;
	}
	
	 public StringProperty getLastNameProperty() {
	        return new SimpleStringProperty(getLastName());
	    }
	 
	 public StringProperty getFirstNameProperty() {
	        return new SimpleStringProperty(getFirstName());
	    }
}