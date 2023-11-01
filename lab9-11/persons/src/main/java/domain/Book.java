	package domain;
	/**
	* Класс данных о должностях
	*/
	public class Book {
	// Идентификатор должности
	private Long id;
	// Наименование должности
	private String namebook;
	
	private String pereplet;
	
	private String izdatelstvo;
	
	private String yearOfBirth;
	
	private String genre;
	
	// Внешний ключ -ссылка на сущность Author
	private Long idAuthor;
	
	// Навигационное свойства - ссылка на автора
	private Author author;
	
	public Book() {
	}
	public Book(String namebook) {
	this.namebook = namebook;
	}
	public Book(Long id, String namebook) {
	this.id = id;
	this.namebook = namebook;
	}
	
	
	public Book(String namebook, String pereplet, String izdatelstvo, String yearOfBirth, Author author) {
		this.namebook = namebook;
		this.pereplet = pereplet;
		this.izdatelstvo = izdatelstvo;
		this.yearOfBirth = yearOfBirth;
		this.author = author;
	}
	
	public Book(String namebook, String pereplet, String izdatelstvo, String yearOfBirth,Long idAuthor ,Author author) {
		this.namebook = namebook;
		this.pereplet = pereplet;
		this.izdatelstvo = izdatelstvo;
		this.yearOfBirth = yearOfBirth;
		this.idAuthor = idAuthor;
		this.author = author;
	}
	
	public Book(Long id,String namebook, String pereplet, String izdatelstvo, String yearOfBirth,Long idAuthor ,Author author) {
		this.id = id;
		this.namebook = namebook;
		this.pereplet = pereplet;
		this.izdatelstvo = izdatelstvo;
		this.yearOfBirth = yearOfBirth;
		this.idAuthor = idAuthor;
		this.author = author;
	}
	
	public Long getId() {
	return id;
	}
	public void setId(Long id) {
	
	this.id = id;
	}
	
	
	public String getNameBook() {
	return namebook;
	}
	public void setNameBook(String namebook) {
	this.namebook = namebook;
	}
	
	
	public String getPereplet() {
		return pereplet;
	}
	public void setPereplet(String pereplet) {
		this.pereplet = pereplet;
	}
	
	
	
	public String getIzdatelstvo() {
		return izdatelstvo;
	}
	public void setIzdatelstvo(String izdatelstvo) {
		this.izdatelstvo = izdatelstvo;
	}
	
	
	public String getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	public Author author () {
	return author;
	}
	public String getAuthor() {
	return author.getLastName();
	}
	
	public void setAuthor(Author author) {
	this.author = author;
	}
	public Long getIdAuthor() {
	return idAuthor;
	}
	public void setIdAuthor(Long idAuthor) {
	this.idAuthor = idAuthor;
	}
	
	
	@Override
	public String toString() {
	return "Author {" + "Id = " + id +
	", namebook = " + namebook +
	", pereplet = " + pereplet +
	", izdatelstvo = " + izdatelstvo +
	", yearOfBirth = " + yearOfBirth +
	", genre = " + genre +
	", nameAuthor = " + getAuthor() +
	"}";
	}
	
	}