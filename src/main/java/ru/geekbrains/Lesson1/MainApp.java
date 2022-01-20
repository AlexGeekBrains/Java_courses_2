package ru.geekbrains.Lesson1;

public class MainApp {
    public static void main(String[] args) {

        Obstacles[] obstacles = new Obstacles[4];
        obstacles[0] = new Treadmill(10);
        obstacles[1] = new Treadmill(60);
        obstacles[2] = new Wall(2);
        obstacles[3] = new Wall(3);


        Player[] player = new Player[3];
        player[0] = new People("Vasya", 500, 3);
        player[1] = new Robot("Vityaz M16", 80, 1);
        player[2] = new Cat("Barsik", 50, 2);


        for (int i = 0; i < player.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if (!obstacles[j].trial(player[i])) {
                    break;
                }

            }

        }
    }
}

