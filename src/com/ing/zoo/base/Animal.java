package com.ing.zoo.base;

public abstract class Animal {
    private String name;
    public abstract String getHelloText();

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println(this.name + ": " + getHelloText());
    }
}
