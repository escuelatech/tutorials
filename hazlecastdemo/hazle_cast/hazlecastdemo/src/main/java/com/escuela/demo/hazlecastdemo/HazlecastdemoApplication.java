package com.escuela.demo.hazlecastdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.escuela")
@SpringBootApplication
public class HazlecastdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HazlecastdemoApplication.class, args);
    }

    public static void main(){
    }

}
