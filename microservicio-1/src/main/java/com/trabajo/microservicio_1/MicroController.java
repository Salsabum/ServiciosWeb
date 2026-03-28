package com.trabajo.microservicio_1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MicroController {

    @GetMapping("/datos")
    public String datos() {
        return "Microservicio funcionando";
    }
}
