public class Book {
    String Name; // Название
    String Binding; // Переплет
    String PublishingHouse; // Издательство
    int YearOfPublishing; // Год издания
    String Genre; // Жанр

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getBinding() {
        return Binding;
    }
    public void setBinding(String binding) {
        Binding = binding;
    }
    public String getPublishingHouse() {
        return PublishingHouse;
    }
    public void setPublishingHouse(String publishingHouse) {
        PublishingHouse = publishingHouse;
    }
    public int getYearOfPublishing() {
        return YearOfPublishing;
    }
    public void setYearOfPublishing(int yearOfPublishing) {
        YearOfPublishing = yearOfPublishing;
    }
    public String getGenre() {
        return Genre;
    }
    public void setGenre(String genre) {
        Genre = genre;
    }

    public Book(){}
    public Book(String name, String binding, String publishingHouse, int yearOfPublishing, String genre) {
        Name = name;
        Binding = binding;
        PublishingHouse = publishingHouse;
        YearOfPublishing = yearOfPublishing;
        Genre = genre;
    }



}
