package com.sanshao.SpringBootDemo.service;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class ScheduleDemo {


    @Scheduled(fixedDelay = 10000)
    public void task1() {
        System.out.println("This is Task1");
    }

    @Scheduled(fixedRate = 10000)
    public void task2() {
        System.out.println("This is Task2");
    }

}
