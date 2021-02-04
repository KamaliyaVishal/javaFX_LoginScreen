package com.test.app.view.login;

import com.test.app.model.ErrorHandler;
import com.test.app.model.User;
import com.test.app.view_model.DataValidation;
import com.test.app.view_model.UserViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private AnchorPane rootArPane;

    @FXML
    private ImageView photoImageView;

    @FXML
    private TextField userNameTextBox;

    @FXML
    private PasswordField passwordPWField;

    @FXML
    private Label userValidateLabel;

    @FXML
    private Label passwordValidateLabel;

    public static ErrorHandler staticErrorHandler;
    public static User staticUser;
    public static String mode = "light";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        setImageProperties();
    }
    @FXML
    protected void switchToDark(){
        rootArPane.setStyle("-fx-background-color: #2b384b");
        mode = "dark";

    }
    @FXML
    protected void switchToLight(){
        rootArPane.setStyle("-fx-background-color: #FFFFFF");
        mode = "light";    }

    @FXML
    public void clearUserLabel(){
        userValidateLabel.setText("");
    }

    @FXML
    public void clearPasswordLabel(){
        passwordValidateLabel.setText("");
    }

    private void clearFields(){
        userNameTextBox.setText("");
        passwordPWField.setText("");
        userValidateLabel.setText("");
        passwordValidateLabel.setText("");
    }

    private boolean dataValidate(){

        boolean returnVal = false;

        if(DataValidation.TextFieldNotEmpty(userNameTextBox.getText())
                && DataValidation.TextFieldNotEmpty(passwordPWField.getText())
                //Checking for maximum Characters
                && DataValidation.isValidMaximumLength(userNameTextBox.getText(),30)
                && DataValidation.isValidMaximumLength(passwordPWField.getText(),16)){
            returnVal = true;
        }
        return returnVal;
    }
    private void dataValidateMessage(){

        //checking for being empty
        if(!(DataValidation.TextFieldNotEmpty(userNameTextBox.getText())
                && DataValidation.TextFieldNotEmpty(passwordPWField.getText()))){


            DataValidation.TextFieldNotEmpty(userNameTextBox.getText(),userValidateLabel ,"Name cannot be empty!");
            DataValidation.TextFieldNotEmpty(passwordPWField.getText(), passwordValidateLabel,"Password cannot ber empty");
            //checking for exceeding limit

        }
        if(!(DataValidation.isValidMaximumLength(userNameTextBox.getText(),30)
                && DataValidation.isValidMaximumLength(passwordPWField.getText(),16))){


            DataValidation.isValidMaximumLength(userNameTextBox.getText(),30, userValidateLabel,"User Name too Long!..(Limit 30)");
            DataValidation.isValidMaximumLength(passwordPWField.getText(),16, passwordValidateLabel,"Password too Long!..(Limit 16)");

        }
    }
    @FXML
    protected void login(ActionEvent actionEvent){
        User user= new User();
        UserViewModel userViewModel = new UserViewModel();
        if(dataValidate()){

            user.setuName(userNameTextBox.getText());
            user.setuPassword(passwordPWField.getText());
            userViewModel.userValidate(user);
            if(staticUser == null){
                clearFields();
            }else{
                userViewModel.loadHome(rootArPane, mode);
            }
        }else{
            dataValidateMessage();
        }
    }
    private void setImageProperties(){
        photoImageView.setFitHeight(100);
        photoImageView.setFitWidth(100);
    }
}
