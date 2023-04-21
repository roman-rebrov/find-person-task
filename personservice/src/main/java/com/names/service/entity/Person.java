package com.names.service.entity;

public class Person {
    private String name;
    private int age;
    private int count;

    public Person(){}
    public Person(String name, int age, int count) {
        this.name = name;
        this.age = age;
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
