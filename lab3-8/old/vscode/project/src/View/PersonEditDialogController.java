package View;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Model.Author;
//import ch.makery.address.util.DateUtil;

/**
 * Окно для изменения информации об адресате.
 *
 */
public class PersonEditDialogController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField middleNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField telephonField;
    @FXML
    private TextField raitingField;
    @FXML
    private TextField popularBookField;


    private Stage dialogStage;
    private Author person;
    private boolean okClicked = false;

    /**
     * Инициализирует класс-контроллер. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Устанавливает сцену для этого окна.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Задаёт адресата, информацию о котором будем менять.
     *
     * @param person
     */
    public void setPerson(Author person) {
        this.person = person;

        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        middleNameField.setText(person.getMiddleName());
        raitingField.setText(Double.toString(person.getRaiting()));
        telephonField.setText(person.getTelephone());
        emailField.setText(person.getEmail());
        popularBookField.setText(person.getPopularBook());

        // birthdayField.setText(DateUtil.format(person.getBirthday()));
       // birthdayField.setPromptText("dd.mm.yyyy");
    }

    /**
     * Returns true, если пользователь кликнул OK, в другом случае false.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Вызывается, когда пользователь кликнул по кнопке OK.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            person.setMiddleName(middleNameField.getText());
            person.setRaiting(Double.parseDouble(raitingField.getText()));
            person.setTelephone(telephonField.getText());
            person.setPopularBook(popularBookField.getText());
            person.setEmail(emailField.getText());
            //person.setBirthday(DateUtil.parse(birthdayField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Вызывается, когда пользователь кликнул по кнопке Cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Проверяет пользовательский ввод в текстовых полях.
     *
     * @return true, если пользовательский ввод корректен
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (middleNameField.getText() == null || middleNameField.getText().length() == 0) {
            errorMessage += "No valid street!\n";
        }

        if (raitingField.getText() == null || raitingField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n";
        } else {
            // пытаемся преобразовать почтовый код в double.
            try {
                Double.parseDouble(raitingField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n";
            }
        }

        if (emailField.getText() == null || emailField.getText().length() == 0) {
            errorMessage += "No valid city!\n";
        }

        if (telephonField.getText() == null || telephonField.getText().length() == 0) {
            errorMessage += "No valid city!\n";
        }

        // if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
        //     errorMessage += "No valid birthday!\n";
        // } else {
        //     if (!DateUtil.validDate(birthdayField.getText())) {
        //         errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
        //     }
        // }


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Показываем сообщение об ошибке.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}