package com.startjava.lesson_2_3.animal;

public class Wolf {
    
    private boolean isMale;
    private String name;
    private float weight;
    private int age;
    private String color;

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean isMale) {
        this.isMale = isMale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 8) {
            System.out.println("Некорректный возраст");
        } else {
            this.age = age;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void go() {
        System.out.println("Идет.");
    }

    public void sit() {
        System.out.println("Сидит.");
    }

    public void run() {
        System.out.println("Бежит.");
    }

    public void howl() {
        System.out.println("Воет.");
    }

    public void hunt() {
        System.out.println("Охотится.");
    }
}