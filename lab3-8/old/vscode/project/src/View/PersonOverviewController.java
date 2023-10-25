package View;


import java.io.IOException;

import Model.Author;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    private Label middleNameLabel;
    @FXML
    private Label telephoneLabel;
    @FXML
    private Label raitingLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label popularBookLabel;


    // Ссылка на главное приложение.
    /**
     *
     */
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
        // Очистка дополнительной информации об адресате.
        showPersonDetails(null);

        // Слушаем изменения выбора, и при изменении отображаем
        // дополнительную информацию об адресате.
        /*
         * В строке personTable.getSelectionModel... мы получаем selectedItemProperty таблицы и добавляем к нему слушателя.
         * Когда пользователь выбирает запись в таблице, выполняется наше лямбда-выражение.
         * Мы берём только что выбранную запись и передаём её в метод showPersonDetails(...).
         */

        personTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    /**
     * Заполняет все текстовые поля, отображая подробности об адресате.
     * Если указанный адресат = null, то все текстовые поля очищаются.
     *
     * @param person — адресат типа Author или null
     */
    public void showPersonDetails(Author person) {
        if (person != null) {
            // Заполняем метки информацией из объекта person.
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            middleNameLabel.setText(person.getMiddleName());
            telephoneLabel.setText(person.getTelephone());
            raitingLabel.setText(Double.toString(person.getRaiting()));
            emailLabel.setText(person.getEmail());
            popularBookLabel.setText(person.getPopularBook());


        } else {
            // Если Person = null, то убираем весь текст.
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            middleNameLabel.setText("");
            telephoneLabel.setText("");
            raitingLabel.setText("");
            emailLabel.setText("");
            popularBookLabel.setText("");
        }
    }

    /**
     * Вызывается, когда пользователь кликает по кнопке удаления.
     */
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            personTable.getItems().remove(selectedIndex);
        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(AlertType.WARNING);
            // alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }

    }
    

    /*
     * @FXML
     * private void handleDeletePerson() {
     * int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
     * if (selectedIndex >= 0) {
     * personTable.getItems().remove(selectedIndex);
     * } else {
     * // Ничего не выбрано.
     * Alert alert = new Alert(AlertType.WARNING);
     * alert.initOwner(mainApp.getPrimaryStage());
     * alert.setTitle("No Selection");
     * alert.setHeaderText("No Person Selected");
     * alert.setContentText("Please select a person in the table.");
     *
     * alert.showAndWait();
     * }
     */

    public boolean showPersonEditDialog(Author person) {
        if (person != null) {
            // Заполняем метки информацией из объекта person.
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            middleNameLabel.setText(person.getMiddleName());
            telephoneLabel.setText(person.getTelephone());
            raitingLabel.setText(Double.toString(person.getRaiting()));
            emailLabel.setText(person.getEmail());
            popularBookLabel.setText(person.getPopularBook());

        } else {
            // Если Person = null, то убираем весь текст.
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            middleNameLabel.setText("");
            telephoneLabel.setText("");
            raitingLabel.setText("");
            emailLabel.setText("");
            popularBookLabel.setText("");
        }

        return false;
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