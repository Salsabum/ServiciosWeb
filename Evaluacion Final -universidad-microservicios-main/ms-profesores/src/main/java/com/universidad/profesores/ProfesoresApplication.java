package com.universidad.profesores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProfesoresApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProfesoresApplication.class, args);
    }
}
