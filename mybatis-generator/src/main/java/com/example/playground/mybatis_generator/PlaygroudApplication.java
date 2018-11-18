package com.example.playground.mybatis_generator;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.example.playgroud.mapper")
public class PlaygroudApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlaygroudApplication.class, args);
    }
}
