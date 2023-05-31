package com.train.train.Controllers;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.train.train.TrainApplication;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Класс `MainController` контролирует поведение главной страницы отображения
 */
@Component
public class MainController {

    @FXML
    private TextField nameField;

    /**
     * Метод для перехода на страницу отображения "addFlight"
     * 
     * @throws IOException если встречается ошибка I/O
     */
    public void switchToAddFlight() throws IOException {
        TrainApplication.setRoot("addFlight");
    }

    /**
     * Метод для перехода на страницу отображения "addTrain"
     * 
     * @throws IOException если встречается ошибка I/O
     */
    public void switchToAddTrain() throws IOException {
        TrainApplication.setRoot("addTrain");
    }
}