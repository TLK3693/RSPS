package Model;


//import java.time.LocalDate;
//import javafx.beans.property.IntegerProperty;
//import javafx.beans.property.ObjectProperty;
//import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;

/**
 * Класс-модель для адресата (Author).
 *
 * @author art
 */
public class Author {

	private final StringProperty firstName;
	private final StringProperty lastName;
    private final StringProperty middleName;
	private final StringProperty telephone; // street -> telephone
	private final DoubleProperty raiting; // postalCode -> raiting
	private final StringProperty email; // city -> email
	private final StringProperty popularBook;

	//private final ObjectProperty<LocalDate> birthday;

	/**
	 * Конструктор по умолчанию.
	 */
	public Author() {
		this(null, null);
	}

	/**
	 * Конструктор с некоторыми начальными данными.
	 *
	 * @param firstName
	 * @param lastName
	 */
	public Author(String firstName, String lastName) { // public Author(String firstName, String lastName, String middleName)
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
        this.middleName = new SimpleStringProperty("-");

		// Какие-то фиктивные начальные данные для удобства тестирования.
		this.telephone = new SimpleStringProperty("+7");
		this.raiting = new SimpleDoubleProperty(0.0);
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

	public double getRaiting() {
		return raiting.get();
	}

	public void setRaiting(double raiting) {
		this.raiting.set(raiting);
	}

	public DoubleProperty raitingProperty() {
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

    //

	// public LocalDate getBirthday() {
	// 	return birthday.get();
	// }

	// public void setBirthday(LocalDate birthday) {
	// 	this.birthday.set(birthday);
	// }

	// public ObjectProperty<LocalDate> birthdayProperty() {
	// 	return birthday;
	// }
}