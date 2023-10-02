import java.io.IOException;

import Model.Author;
import View.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Hellofx extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();

        showPersonOverview();
    }

    /**
	 * Данные, в виде наблюдаемого списка адресатов.
	 */
	//public ObservableList<Author> authorData = FXCollections.observableArrayList();

	// /**
	//  * Конструктор
	//  */
	// public Hellofx() {
	// 	// В качестве образца добавляем некоторые данные
	// 	authorData.add(new Author("Hans", "Muster"));
	// 	authorData.add(new Author("Ruth", "Mueller"));
	// 	authorData.add(new Author("Heinz", "Kurz"));
	// 	authorData.add(new Author("Cornelia", "Meier"));
	// 	authorData.add(new Author("Werner", "Meyer"));
	// 	authorData.add(new Author("Lydia", "Kunz"));
	// 	authorData.add(new Author("Anna", "Best"));
	// 	authorData.add(new Author("Stefan", "Meier"));
	// 	authorData.add(new Author("Martin", "Mueller"));
	// }

	// /**
	//  * Возвращает данные в виде наблюдаемого списка адресатов.
	//  * @return
	//  */
	// public ObservableList<Author> getAuthorData() {
	// 	return authorData;
	// }


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

    public static void main(String[] args) {
        launch(args);
    }
    //
}