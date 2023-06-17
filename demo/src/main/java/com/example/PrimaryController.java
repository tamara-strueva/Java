package com.example;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML
    private TextField lowerBound;
    @FXML
    private TextField upperBound;
    @FXML
    private Button generate;
    // @FXML
    // private Label resultShow;
    @FXML
    private TextField resultShow;

    // @FXML
    // public void handleButtonClick(ActionEvent event) {
    // String text = myTextField.getText();
    // System.out.println("Введенный текст: " + text);
    // }

    @FXML
    public void showNumbers() {
        System.out.println("1 = " + lowerBound.getText());
        System.out.println("2 = " + upperBound.getText());
        String num1 = lowerBound.getText();
        String num2 = upperBound.getText();
        try {
            int number1 = Integer.parseInt(num1);
            int number2 = Integer.parseInt(num2);
            System.out.println("1 = " + number1 + " 2 = " + number2);
            if (number1 < number2) {
                ArrayList<Integer> numbers = generateList(number1, number2);
                if (number2 < 0) {
                    // System.out.println("Нет двузначных положительных чисел"); // !!
                    resultShow.setText("Нет двузначных положительных чисел");
                } else {
                    int first = findFirst(numbers);
                    // System.out.println("^&*" + first);

                    if (first == -1) {
                        // System.out.println("Нет двузначных положительных чисел"); // !!
                        resultShow.setText("Нет двузначных положительных чисел");
                    } else {
                        ArrayList<Integer> result = new ArrayList<>();
                        for (int i = first; i < numbers.size(); i++) {
                            if (numbers.get(i) < 100) {
                                result.add(numbers.get(i));
                            } else {
                                break;
                            }
                        }
                        System.out.println(result); // !!
                        String res = result.toString();
                        resultShow.setText(res);
                    }

                }

            } else {
                // System.out.println("Первое число должно быть МЕНЬШЕ второго!!"); // !!
                resultShow.setText("Первое число должно быть МЕНЬШЕ второго!!");
            }

        } catch (NumberFormatException err) {
            // System.out.println("Incorrect input!"); // !!
            resultShow.setText("Некорректный ввод данных диапазона чисел!!");
        }
    }

    public ArrayList<Integer> generateList(int start, int end) {
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = start; i < end; i++) {
            nums.add(i);
        }
        return nums;
    }

    public int findFirst(ArrayList<Integer> numbers) {
        // int first;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > 9 && numbers.get(i) < 100) {
                int first = numbers.indexOf(numbers.get(i));
                return first;
            }
        }
        return -1;
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
