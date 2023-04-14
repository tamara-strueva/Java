package com.example.pizza.web;
// связь с order.html

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.pizza.OrderPizza;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("orderPizza")
public class OrderController {
    // метод для отображения страницы в браузере, возврат строки-представления
    @GetMapping("/current") 
    public String showOrderForm(){
        return "order";
    }

    // переход на приветственную страницу, но в случае ошибки вернет страницу оформления доставки
    @PostMapping
    public String processOrder(@Valid OrderPizza orderPizza, Errors errors, SessionStatus sessionStatus){
        if (errors.hasErrors()){
            return "order";
        }
        log.info("Order submitted {}", orderPizza); // вывод логгирования и данных о заказе в терминал
        sessionStatus.setComplete();
        return "redirect:/"; // переадресация на главную страницу
    }

    

}
