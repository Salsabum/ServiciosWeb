package com.trabajo.microservicio_2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Micro2Controller {

    @GetMapping("/datos")
    public String datos() {
        return "Respuesta desde Microservicio 2";
    }
}
