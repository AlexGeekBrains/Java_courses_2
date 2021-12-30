package ru.geekbrains.Lesson1;

public class Treadmill implements Obstacles {
    private int distance;

    public Treadmill(int distance) {
        if (distance > 0) {
            this.distance = distance;
        } else {
            System.out.println("Значение поля дистанция введено неверно");
        }
    }

    @Override
    public int getLevel() {
        return distance;
    }

    @Override
    public boolean trial(Player player) {
        if (player.getEndurance() >= getLevel()) {
            player.run();
            return true;
        } else {
            System.out.println("учасник " + player.toString() + "сошел с беговой дорожки, не смог преодолеть расстояние в " + distance + " метров и выбывает из марафона");
        }
        return false;
    }
}

