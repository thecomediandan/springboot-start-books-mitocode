package com.ardadev.mitocodeexample.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StartController {

    @GetMapping
    public String greetings() {
        return "Bienvenido a mi ejemplo de Springboot :D";
    }
}
