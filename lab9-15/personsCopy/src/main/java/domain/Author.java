package domain;
/**
* Класс для данных сотрудника
*/
public class Author {
// Идентификатор сотрудника
 private Long id;

 // Имя
 private String firstName;

 // Фамилия
 private String lastName;
 
 // Отчество
 private String middleName;

 // Рейтинг
 private Integer raiting;
 
 //Телефон
 private String phone;

 // email
 private String email;

 // Внешний ключ -ссылка на сущность Role
 private Long idBook;

 // Навигационное свойства - ссылка на должность
 private Book book;
 public Author() {
}

 public Author(String firstName, String lastName, String middleName,Integer raiting, String email) {
 this.firstName = firstName;
 this.lastName = lastName;
 this.middleName = middleName;
 this.email = email;
 this.raiting = raiting;
 }

 public Author(Long id,String firstName, String lastName, String middleName, Integer raiting,String phone,String email, Long idBook, Book book) {
	 this.id = id;
	 this.firstName = firstName;
	 this.lastName = lastName;
	 this.middleName = middleName;
	 this.raiting = raiting;
	 this.phone = phone;
	 this.email = email;
	 this.idBook = idBook;
	 this.book = book;
 }
// public Author(String firstName, String lastName, String raiting,
// String email) {
// this.firstName = firstName;
// this.lastName = lastName;
// this.email = email;
// this.raiting = raiting;
// this.book = book;
// this.idRole = idRole;
// }


public String getFirstName() {
return firstName;
}
public void setFirstName(String firstName) {
this.firstName = firstName;
}


public String getLastName() {
return lastName;
}
public void setLastName(String lastName) {
this.lastName = lastName;
}


public String getMiddleName() {
return middleName;
}
public void setMiddleName(String middleName) {
this.middleName = middleName;
}


public String getPhone() {
return phone;
}
public void setPhone(String phone) {
this.phone = phone;
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

public Book book () {
return book;
}

public String getBook() {
return book.getNameBook();
}
public void setBook(Book role) {
this.book = role;
}

public Long getIdBook() {
return idBook;
}
public void setIdBook(Long idBook) {
this.idBook = idBook;
}


public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}

public Integer getRaiting() {
return raiting;
}
public void setRaiting(Integer raiting) {
this.raiting = raiting;
}


@Override
public String toString() {
return "Author {" + "Id = " + id +
", firstName = " + firstName +
", lastName = " + lastName +
", middleName = " + middleName +
", phone = " + phone +
", email = " + email +
", raiting = " + raiting +
"}";
}
}