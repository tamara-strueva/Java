package com.example.pizza.web;
// класс конвертирует ингредиент в строку

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.pizza.Ingredient;
import com.example.pizza.Ingredient.Type;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    // класс для коныертации ингредиентов в строку и обратно, для корректного обменя данными и заполения формы заказа
    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    // создание словаря ингредиентов с ключами в виде строк id
    public IngredientByIdConverter() { 
        ingredientMap.put("SLIM", new Ingredient("SLIM", "Тонкое тесто", Type.DOUGH));
        ingredientMap.put("TRAD", new Ingredient("TRAD", "Традиционное тесто", Type.DOUGH));
        ingredientMap.put("PIG", new Ingredient("PIG", "Свинина", Type.MEAT));
        ingredientMap.put("COW", new Ingredient("COW", "Говядина", Type.MEAT));
        ingredientMap.put("CHICK", new Ingredient("CHICK", "Курица", Type.MEAT));
        ingredientMap.put("TMT", new Ingredient("TMT", "Помидор", Type.VEGGIES));
        ingredientMap.put("CUC", new Ingredient("CUC", "Огурец", Type.VEGGIES));
        ingredientMap.put("SAL", new Ingredient("SAL", "Салат", Type.VEGGIES));
        ingredientMap.put("PAP", new Ingredient("PAP", "Перец", Type.VEGGIES));
        ingredientMap.put("CHED",new Ingredient("CHED", "Чеддер", Type.CHEESE));
        ingredientMap.put("SUL", new Ingredient("SUL", "Сулугуни", Type.CHEESE));
        ingredientMap.put("KETCH", new Ingredient("KETCH", "Кетчуп", Type.SAUSE));
        ingredientMap.put("TERK", new Ingredient("TERK", "Терияки", Type.SAUSE));
        ingredientMap.put("BBQ", new Ingredient("BBQ", "Барбекю", Type.SAUSE));
    }

    // вытаскиваем из словаря ингредиент по клюу-строке
    @Override
    public Ingredient convert(String id) { 
        return ingredientMap.get(id);
    }    
}
