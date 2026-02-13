package com.portfolio.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BlogApplication {

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }

    static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

}
