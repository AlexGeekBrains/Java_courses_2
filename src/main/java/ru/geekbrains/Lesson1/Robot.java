package ru.geekbrains.Lesson1;

public class Robot implements Player {
    private String model;
    private int endurance;
    private int agility;

    public Robot(String model, int endurance, int agility) {
        this.model = model;
        this.endurance = endurance;
        this.agility = agility;
    }


    @Override
    public String toString() {
        return "Robot{" +
                "model='" + model + '\'' +
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
        System.out.println("Робот " + model + " пробежал дистанцию");
    }

    @Override
    public void jump() {
        System.out.println("Робот " + model + " перепрыгнул через препятствие");
    }
}
