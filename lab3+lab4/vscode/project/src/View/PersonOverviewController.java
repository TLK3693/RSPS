package View;

//import Hellofx;
import Model.Author;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonOverviewController<Hellofx> {
    @FXML
    private TableView<Author> personTable;
    @FXML
    private TableColumn<Author, String> firstNameColumn;
    @FXML
    private TableColumn<Author, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label telephoneLabel;
    @FXML
    private Label raitingLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label popularBookLabel;


    // Ссылка на главное приложение.
    public Hellofx mainApp;

    private ObservableList<Author> authorData = FXCollections.observableArrayList();
    public ObservableList<Author> SetObservableListOfAuthor() {
		// В качестве образца добавляем некоторые данные
		authorData.add(new Author("Михаил", "Булгаков"));
		authorData.add(new Author("Николай", "Гоголь"));
		authorData.add(new Author("Александр", "Дюма"));
		authorData.add(new Author("Александр", "Пушкин"));
		authorData.add(new Author("Василий ", "Жуковский"));
		authorData.add(new Author("Александр", "Грибоедов"));
		authorData.add(new Author("Михаил", "Лермонтов"));
		authorData.add(new Author("Иван", "Тургенев"));
		authorData.add(new Author("Александр", "Островский"));
        return authorData;
	}

    /**
     * Конструктор.
     * Конструктор вызывается раньше метода initialize().
     */
    public PersonOverviewController() {
    }

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
    	// Инициализация таблицы адресатов с двумя столбцами.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    }

    /**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     *
     * @param mainApp
     */
    public void setMainApp(Hellofx mainApp) {
        this.mainApp = mainApp;

        // Добавление в таблицу данных из наблюдаемого списка
        personTable.setItems(SetObservableListOfAuthor());
    }
}