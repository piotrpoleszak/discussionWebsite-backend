package com.poleszak.webApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class WebAppApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(WebAppApplication.class, args);
    }
}
