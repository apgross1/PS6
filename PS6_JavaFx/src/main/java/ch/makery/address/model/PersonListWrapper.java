package ch.makery.address.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import domain.PersonDomainModel;
import javafx.collections.ObservableList;

/**
 * Helper class to wrap a list of persons. This is used for saving the
 * list of persons to XML.
 * 
 * @author Marco Jakob
 */
@XmlRootElement(name = "persons")
public class PersonListWrapper {

    private ObservableList<PersonDomainModel> persons;

    @XmlElement(name = "person")
    public ObservableList<PersonDomainModel> getPersons() {
        return persons;
    }

    public void setPersons(ObservableList<PersonDomainModel> personData) {
        this.persons = personData;
    }
}