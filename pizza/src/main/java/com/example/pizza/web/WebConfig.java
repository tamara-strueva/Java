package com.example.pizza.web;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; // имплентирует
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry; // репозиторий
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // без этого класса пакет не соберется и приложение не запустится

    // метод открывает в браузере приветственную страницу (welcome.html)
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("welcome");
    }
    
}
