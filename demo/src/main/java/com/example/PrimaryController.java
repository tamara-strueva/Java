package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML
    private TextField myTextField;
    @FXML
    private Button myButton;

    @FXML
    public void handleButtonClick(ActionEvent event) {
        String text = myTextField.getText();
        System.out.println("Введенный текст: " + text);
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
