package com.example.pizza;
// заказ, который формируется из 1 и более пицц

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data // аннотация, которая позволяет не прописывать конструктор и геттеры/сеттеры
public class OrderPizza {
    @NotBlank(message = "Наименование доставки обязательно для заполнения")
    private String deliveryName;

    @NotBlank(message = "Улица доставки обязательно для заполнения")
    private String deliveryStreet;

    @NotBlank(message = "Город доставки обязательно для заполнения")
    private String deliveryCity;

    @CreditCardNumber // формат ввода номера карты - 16 цифр (почему-то успешно срабатывает только при всех нулях)
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][3-9])$", message="Формат MM/YY")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Неправильный CVV")
    private String ccCVV;

    // список пицц, к нему ОБЯЗАТЕЛЬНО надо обратиться в инерации order.html
    private List<Pizza> pizzas = new ArrayList<>();

    public void addPizza(Pizza pizza) { // добавление пиццы в заказ
        this.pizzas.add(pizza);
    }
}
