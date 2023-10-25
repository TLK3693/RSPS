import java.io.IOException;

import View.PersonEditDialogController;
import View.PersonOverviewController;
import Model.Author;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Hellofx extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    /**
     *
     */
    //Hellofx(){}

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AuthorApp");

        initRootLayout();

        showPersonOverview();
    }

    /**
	 * Данные, в виде наблюдаемого списка адресатов.
	 */
	public ObservableList<Author> authorData = FXCollections.observableArrayList();

	/**
	 * Конструктор
	 */
	public Hellofx() {
		// В качестве образца добавляем некоторые данные
		authorData.add(new Author("Hans", "Muster"));
		authorData.add(new Author("Ruth", "Mueller"));
		authorData.add(new Author("Heinz", "Kurz"));
		authorData.add(new Author("Cornelia", "Meier"));
		authorData.add(new Author("Werner", "Meyer"));
		authorData.add(new Author("Lydia", "Kunz"));
		authorData.add(new Author("Anna", "Best"));
		authorData.add(new Author("Stefan", "Meier"));
		authorData.add(new Author("Martin", "Mueller"));
	}

	/**
	 * Возвращает данные в виде наблюдаемого списка адресатов.
	 * @return
	 */
	public ObservableList<Author> getAuthorData() {
		return authorData;
	}


    /**
     * Инициализирует корневой макет.
     */
    public void initRootLayout() {
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Hellofx.class.getResource("/View/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Показывает в корневом макете сведения об адресатах.
     * @param hellofx TODO
     */
    public void showPersonOverview() {
        try {
            // Загружаем сведения об адресатах.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Hellofx.class.getResource("/View/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Помещаем сведения об адресатах в центр корневого макета.
            rootLayout.setCenter(personOverview);

            // Даём контроллеру доступ к главному приложению.
            PersonOverviewController controller = loader.getController();
            //controllerhellofx.getAuthorData();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Возвращает главную сцену.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Открывает диалоговое окно для изменения деталей указанного адресата.
     * Если пользователь кликнул OK, то изменения сохраняются в предоставленном
     * объекте адресата и возвращается значение true.
     *
     * @param person - объект адресата, который надо изменить
     * @return true, если пользователь кликнул OK, в противном случае false.
     */
    public boolean showPersonEditDialog(Author person) {
        try {
            // Загружаем fxml-файл и создаём новую сцену
            // для всплывающего диалогового окна.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Hellofx.class.getResource("/View/PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Создаём диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Author");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаём адресата в контроллер.
            PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    @FXML
    private TableView<Author> personTable;

    public PersonOverviewController per;

    /**
     * Вызывается, когда пользователь кликает по кнопке New...
     * Открывает диалоговое окно с дополнительной информацией нового адресата.
     */
    @FXML
    private void handleNewPerson() {
        Author tempPerson = new Author();
        boolean okClicked = showPersonEditDialog(tempPerson);
        if (okClicked) {    
            getAuthorData().add(tempPerson);
        }
    }
    /**
     * Вызывается, когда пользователь кликает по кнопка Edit...
     * Открывает диалоговое окно для изменения выбранного адресата.
     */
    @FXML
    private void handleEditPerson() {
        Author selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = per.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                per.showPersonDetails(selectedPerson);
            }

        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(AlertType.WARNING);
            //alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
    //
}