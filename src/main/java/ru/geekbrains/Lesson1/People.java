package ru.geekbrains.Lesson1;

public class People implements Player {
    private String name;
    private int endurance;
    private int agility;

    public People(String name, int endurance, int agility) {
        this.name = name;
        this.endurance = endurance;
        this.agility = agility;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int getAgility() {
        return agility;
    }

    @Override
    public int getEndurance() {
        return endurance;
    }

    @Override
    public void run() {
        System.out.println("Человек " + name + " пробежал дистанцию длинною");
    }

    @Override
    public void jump() {
        System.out.println("Человек " + name + " перепрыгнул через препятствие");
    }
}
