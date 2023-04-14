package com.example.pizza;
// сама пицца, которая состоит из ингредиентов


import java.util.List;

import lombok.Data; 
import jakarta.validation.constraints.NotNull; 
import jakarta.validation.constraints.Size;


@Data // аннотация, которая позволяет не прописывать конструктор и геттеры/сеттеры
public class Pizza {
    // в окошко, потом в лист, а можно и еще созать (на сайте при заполнении формы)

    @NotNull // имя пиццы не может отсутствовать
    @Size(min = 3, message = "минимум 3 знака") // минимальное количество символов - 5
    private String name;

    @NotNull // нельзя, чтобы пицца была без ингредиентов
    @Size(min = 2, message = "минимум 2 ингредиента") // минимальное количество ингредиентов - 2
    private List<Ingredient> ingredients;
    
}
