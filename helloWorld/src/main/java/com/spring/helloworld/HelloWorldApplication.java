package com.spring.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication


@RestController
public class HelloWorldApplication {
        public static void main(String[] args) {
                SpringApplication.run(HelloWorldApplication.class, args);
        }
        
        // 1. Annotation
        @RequestMapping("/")
        // 3. Method that maps to the request route above
        public String index() { // 3
                return "Hello World";
        }
        
        @RequestMapping("/new_route")
        // 3. Method that maps to the request route above
        public String indexTwo() { // 3
                return "Hello Matt!";
        }
}
