package com.example.pizza;
// ингредиент, из которого состоит пицца

import lombok.Data;

@Data // аннотация, которая позволяет не прописывать конструктор и геттеры/сеттеры
public class Ingredient {

    private final String id; // final для обязательного заполнения в конструкторе, который сгенерирован @Data
    private final String name;
    private final Type type;

    public enum Type {
        DOUGH, 
        MEAT,
        VEGGIES,
        CHEESE,
        SAUSE
    }
    
}
