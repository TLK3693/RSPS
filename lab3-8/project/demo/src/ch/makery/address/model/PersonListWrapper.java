package ch.makery.address.model;

//import jakarta.xml.bind.*;
//import jakarta.xml.bind.annotation.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import ch.makery.address.model.Person;

@XmlRootElement(name = "persons")
//@XmlRootElement(name = "authors")
public class PersonListWrapper {

    private List<Person> persons;

    @XmlElement(name = "person")
    //@XmlElement(name = "author")
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}