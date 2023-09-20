import java.util.List;

public class Author implements AuthorInterface {
    String LastName; // Имя
    String FirstName; // Фамилия
    String Surname; // Отчество
    String Telephone;
    String Email;
    double Rating;
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public String getSurname() {
        return Surname;
    }
    public void setSurname(String surname) {
        Surname = surname;
    }
    public String getTelephone() {
        return Telephone;
    }
    public void setTelephone(String telephone) {
        Telephone = telephone;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public double getRating() {
        return Rating;
    }
    public void setRating(double rating) {
        Rating = rating;
    }

    public Author(){}
    public Author(String lastName, String firstName, String surname, String telephone, String email, double rating) {
        LastName = lastName;
        FirstName = firstName;
        Surname = surname;
        Telephone = telephone;
        Email = email;
        Rating = rating;
    }
    @Override
    public void Info(List<Author> authors) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Info'");
    }
}
