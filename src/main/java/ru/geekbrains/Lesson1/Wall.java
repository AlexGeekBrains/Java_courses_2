package ru.geekbrains.Lesson1;

public class Wall implements Obstacles {
    private int height;

    public Wall(int height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("Значение поля высота введено неверно");
        }
    }

    public int getLevel() {
        return height;
    }

    @Override
    public boolean trial(Player player) {
        if (player.getAgility() >= getLevel()) {
            player.jump();
            return true;
        } else {
            System.out.println("учасник " + player.toString() + "не смог преодолеть препятствие стена в " + height + " метра и выбывает из марафона");
            return false;
        }
    }
}
