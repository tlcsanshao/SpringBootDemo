package com.sanshao.SpringBootDemo.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerDemo implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Hello world");

    }
}
