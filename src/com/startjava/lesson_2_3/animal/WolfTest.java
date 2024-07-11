package com.startjava.lesson_2_3.animal;

public class WolfTest {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        wolf.setMale(true);
        wolf.setName("Ганс");
        wolf.setWeight(50.4f);
        wolf.setAge(5);
        wolf.setColor("серый");
        System.out.println("isMale: " + wolf.isMale());
        System.out.println("name: " + wolf.getName());
        System.out.println("weight: " + wolf.getWeight());
        System.out.println("age: " + wolf.getAge());
        System.out.println("color: " + wolf.getColor());
        wolf.go();
        wolf.sit();
        wolf.run();
        wolf.howl();
        wolf.hunt();
    }
}