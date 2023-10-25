package ch.makery.address.model;

import javafx.beans.property.*;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

//import ch.makery.address.util.LocalDateAdapter;

/**
 * Model class for a Person.
 *
 * @author Marco Jakob
 */
public class Person {

    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty middleName;
    private final StringProperty telephone; // street -> telephone
    private final IntegerProperty raiting; // postalCode -> raiting
    private final StringProperty email; // city -> email
    private final StringProperty popularBook;

    /**
     * Default constructor.
     */
    public Person() {
        this(null, null);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.middleName = new SimpleStringProperty("-");

        // Какие-то фиктивные начальные данные для удобства тестирования.
        this.telephone = new SimpleStringProperty("+7");
        this.raiting = new SimpleIntegerProperty((int) (Math.random()* 9));
        this.email = new SimpleStringProperty("@mail.ru");
        this.popularBook = new SimpleStringProperty("Book");
        //this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }
    //

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }
    //

    public String getMiddleName() {
        return middleName.get();
    }

    public void setMiddleName(String middleName) {
        this.middleName.set(middleName);
    }

    public StringProperty middleNameProperty() {
        return middleName;
    }
    //

    public String getTelephone() {
        return telephone.get();
    }

    public void setTelephone(String street) {
        this.telephone.set(street);
    }

    public StringProperty telephoneProperty() {
        return telephone;
    }
    //


    public int getRaiting() {
        return raiting.get();
    }

    public void setRaiting(int raiting) {
        this.raiting.set(raiting);
    }

    public IntegerProperty raitingProperty() {
        return raiting;
    }
    //

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty cityProperty() {
        return email;
    }
    //

    public String getPopularBook() {
        return popularBook.get();
    }

    public void setPopularBook(String popularBook) {
        this.popularBook.set(popularBook);
    }

    public StringProperty PopularBookProperty() {
        return popularBook;
    }


    //@XmlJavaTypeAdapter(LocalDateAdapter.class)
//    public LocalDate getBirthday() {
//        return birthday.get();
//    }
//
//    public void setBirthday(LocalDate birthday) {
//        this.birthday.set(birthday);
//    }
//
//    public ObjectProperty<LocalDate> birthdayProperty() {
//        return birthday;
//    }
}