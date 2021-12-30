package ru.geekbrains.Lesson1;

public class Cat implements Player {
    private String nickname;
    private int endurance;
    private int agility;


    public Cat(String nickname, int endurance, int agility) {
        this.nickname = nickname;
        this.endurance = endurance;
        this.agility = agility;
    }

    public String info() {
        return "Кот" + nickname;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "nickname='" + nickname + '\'' +
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
        System.out.println("Кот " + nickname + " пробежал дистанцию");
    }

    @Override
    public void jump() {
        System.out.println("Кот " + nickname + " перепрыгнул через препятствие");
    }
}

