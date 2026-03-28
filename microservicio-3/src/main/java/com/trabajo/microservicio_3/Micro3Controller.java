package com.trabajo.microservicio_3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Micro3Controller {

    @GetMapping("/datos")
    public String datos() {
        return "Respuesta desde Microservicio 3";
    }
}
