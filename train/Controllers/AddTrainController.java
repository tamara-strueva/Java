package com.train.train.Controllers;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.train.train.TrainApplication;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Класс `AddTrainController` контролирует поведение страницы отображения
 * "addTrain"
 */
@Component
public class AddTrainController {

    @FXML
    private TextField nameField;

    /**
     * Метод для возвращения на главную страницу
     * 
     * @throws IOException если встречается ошибка I/O
     */
    public void returnToMainTR() throws IOException {
        TrainApplication.setRoot("main");
    }
}