class Animal {
    protected String name;
    protected static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}

class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            super.swim(distance);
        } else {
            System.out.println(name + " не может проплыть " + distance + " м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}

class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull = false;
    private static int foodBowl = 0;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(int amount) {
        if (amount <= foodBowl) {
            foodBowl -= amount;
            isFull = true;
            System.out.println(name + " покушал. Сытость: " + isFull);
        } else {
            System.out.println(name + " не может поесть, недостаточно еды.");
        }
    }

    public static void addFood(int amount) {
        foodBowl += amount;
        System.out.println("В миске теперь " + foodBowl + " еды.");
    }

    public static int getCatCount() {
        return catCount;
    }

    public boolean isFull() {
        return isFull;
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Бобик");
        dog1.run(150);
        dog1.swim(5);

        Cat cat1 = new Cat("Мурка");
        cat1.run(50); // Успешно пробежит
        cat1.swim(5); // Не умеет плавать

        Cat[] cats = {new Cat("Кот1"), new Cat("Кот2"), new Cat("Кот3")};
        Cat.addFood(20); // Наполняем миску

        for (Cat cat : cats) {
            cat.eat(10); // Каждый кот пытается поесть
        }

        System.out.println("Общее количество животных: " + Animal.getAnimalCount());
        System.out.println("Количество собак: " + Dog.getDogCount());
        System.out.println("Количество котов: " + Cat.getCatCount());
    }
}