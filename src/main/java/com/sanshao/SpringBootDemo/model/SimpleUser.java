package com.sanshao.SpringBootDemo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.lang.annotation.Native;

@Entity
public class SimpleUser {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true,nullable = false)
    private String name;

    @Column
    private int age;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SimpleUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public SimpleUser(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public SimpleUser() {
    }
}
