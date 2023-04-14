package com.example.pizza.web;
// связь с disign.html

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller; // преобразовывает java в http
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping; // обертка класса для http запросов
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.pizza.Ingredient;
import com.example.pizza.OrderPizza;
import com.example.pizza.Pizza;
import com.example.pizza.Ingredient.Type;

import org.springframework.ui.Model;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j // логгирование
@Controller // класс является контроллером
@RequestMapping("/design") // отвечает за страницу дизайна, все методы в строке будудт иметь /design
@SessionAttributes("orderPizza") // во время сессии собирается заказ, т.е. пицца(ы) будут добавляться в него
public class DesignController {
    // метод для отображения страницы в браузере, возврат строки-представления    
    @GetMapping
    public String showDesignForm(){ 
        return "design";
    }

    // создание объекта в html и обращение к его атрибутам
    @ModelAttribute(name="pizza") // в html будет такое обращение
    public Pizza pizza() {
        return new Pizza();
    }

    @ModelAttribute(name="orderPizza") // в html будет такое обращение
    public OrderPizza orderPizza() {
        return new OrderPizza();
    }

    // создание списка из ингредиентов и добавление их в модель
    @ModelAttribute
    public void addIngredientsToModel(Model model){
        List<Ingredient> ingredients = Arrays.asList(
            new Ingredient("SLIM", "Тонкое тесто", Type.DOUGH),
            new Ingredient("TRAD", "Традиционное тесто", Type.DOUGH),
            new Ingredient("PIG", "Свинина", Type.MEAT),
            new Ingredient("COW", "Говядина", Type.MEAT),
            new Ingredient("CHICK", "Курица", Type.MEAT),
            new Ingredient("TMT", "Помидор", Type.VEGGIES),
            new Ingredient("CUC", "Огурец", Type.VEGGIES),
            new Ingredient("SAL", "Салат", Type.VEGGIES),
            new Ingredient("PAP", "Перец", Type.VEGGIES),
            new Ingredient("CHED", "Чеддер", Type.CHEESE),
            new Ingredient("SUL", "Сулугуни", Type.CHEESE),
            new Ingredient("KETCH", "Кетчуп", Type.SAUSE),
            new Ingredient("TERK", "Терияки", Type.SAUSE),
            new Ingredient("BBQ", "Барбекю", Type.SAUSE)
        );

        // сортировка ингредиентов по типу
        Type[] types = Ingredient.Type.values();
        for(Type type: types){
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }
    
    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
        // ingredients.stream() – создание стрима (потока) из списка
        // filter(x -> x.getType().equals(type)) – фильтрация по типам ингредиентов
        // collect(Collector collector) – метод собирает все элементы в список, множество или другую коллекцию, сгруппировывает элементы по какому-нибудь критерию, объединяет всё в список
    }

    // переход на страницу с оформлением доставки, но в случае ошибки вернет страницу оформления заказа
    @PostMapping
    public String processPizza(@Valid Pizza pizza, Errors errors, @ModelAttribute OrderPizza orderPizza){
        if (errors.hasErrors()){
            return "design";
        }
        orderPizza.addPizza(pizza);
        log.info("Processing pizza: {}", pizza); // чтобы не было ошибки, нужно было импортировать @Slf4j (выведет сообщение и состав пиццы в терминал)
        return "redirect:/orders/current"; // если заказ сформирован успешно, то переходит на страницу оформления доставки
    }  
}
