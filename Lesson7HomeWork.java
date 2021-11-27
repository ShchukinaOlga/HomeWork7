/**
 * Java 1. HomeWork 7
 *
 @ autor Shchukina Olga
 @ version 27.11.2021
*/

import java.util.Arrays;

class Lesson7HomeWork {
    public static void main(String[] args) {
        Cat[] cat = new Cat[3];
        cat[0] = new Cat("Murzik", 3);
        cat[1] = new Cat("Vasya", 4);
        cat[2] = new Cat("Pushok", 1);

        Plate plate = new Plate(10);
        System.out.println(Arrays.toString(cat));
        System.out.println(plate);

        for (Cat i : cat) {
            i.eat(plate);
            System.out.println(Arrays.toString(cat));
        }

        System.out.println(plate);
        plate.increaseFood(10);
        System.out.println(plate);

        for (Cat i : cat) {
            i.setSatiety(false);
            i.eat(plate);
            System.out.println(Arrays.toString(cat));
        }
        System.out.println(plate);
    }
}

class Cat {
    String name;
    int appetite;
    boolean satiety;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    void setSatiety(boolean sat) {
        satiety = sat;
    }

    void eat(Plate plate) {
        if (!satiety) {
            satiety = plate.decreaseFood(appetite);
        }
    }

    @Override
    public String toString() {
        return name + ", appetite: " + appetite;
    }
}

class Plate {
    int food;

    Plate(int food) {
        this.food = food;
    }

    boolean decreaseFood(int n) {
        if (food < n) {
            return false;
        }
        food -= n;
        return true;
    }

     void increaseFood(int food) {
        this.food += food;
    }

    @Override
    public String toString() {
        return "Food: " + food;
    }
}