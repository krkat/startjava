package com.startjava.lesson_2_3.person;


public class Person {
    private boolean isMale = true;
    private String name = "Дима";
    private float height = 1.8f;
    private float weight = 80.5f;
    private int age = 30;

    public void go() {
        System.out.println(name + " идет.");
    }

    public void sit() {
        System.out.println(name + " сидит.");
    }

    public void say() {
        System.out.println(name + " говорит.");
    }

    public void run() {
        System.out.println(name + " бежит.");
    }

    public void learnJava() {
        System.out.println(name + " учит Java.");
    }
}