package com.test.app.view.home;


import com.test.app.view.login.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private AnchorPane rootArPane;

    @FXML
    private Label welcomeLabel;
    public  static String mode = "light";
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getMode();
    }
    @FXML
    protected void switchToDark(){
        rootArPane.setStyle("-fx-background-color: #2b384b");
    }
    @FXML
    protected void switchToLight(){
        rootArPane.setStyle("-fx-background-color: #FFFFFF");
    }
    //setting mode and user
    private void getMode(){
        mode = LoginController.mode;
        if(mode.equals("dark"))
            switchToDark();
        welcomeLabel.setText("Hello Welcome "+LoginController.staticUser.getuName() + " !!");
    }
}
