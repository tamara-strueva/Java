package com.train.train.Controllers;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.train.train.TrainApplication;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Класс `AddFlightController` контролирует поведение страницы отображения
 * "addFlight"
 */
@Component
public class AddFlightController {

    @FXML
    private TextField nameField;

    /**
     * Метод для возвращения на главную страницу
     * 
     * @throws IOException если встречается ошибка I/O
     */
    public void returnToMain() throws IOException {
        TrainApplication.setRoot("main");
    }
}