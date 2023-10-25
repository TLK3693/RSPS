package ch.makery.address.view;

import ch.makery.address.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Dialog to edit details of a person.
 * 
 * @author Marco Jakob
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
    private Person person;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        
        // Set the dialog icon.
        this.dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));
    }

    /**
     * Sets the person to be edited in the dialog.
     * 
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;

        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        middleNameField.setText(person.getMiddleName());
        raitingField.setText(Double.toString(person.getRaiting()));
        telephonField.setText(person.getTelephone());
        emailField.setText(person.getEmail());
        popularBookField.setText(person.getPopularBook());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            person.setMiddleName(middleNameField.getText());
            person.setRaiting(Integer.parseInt(raitingField.getText()));
            person.setTelephone(telephonField.getText());
            person.setPopularBook(popularBookField.getText());
            person.setEmail(emailField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
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
                Integer.parseInt(raitingField.getText());
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
            // Show the error message.
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