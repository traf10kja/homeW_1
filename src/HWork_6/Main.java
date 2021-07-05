package HWork_6;


import HWork_6.animals.Animal;
import HWork_6.animals.Cat;
import HWork_6.animals.Dog;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("f", "fff", 100);
        Cat cat = new Cat("Murzik", "gray", 5);
        Cat cat2 = new Cat("Gav", "white", 3);
        Cat cat3 = new Cat("Kinya", "black", 1);
        Cat cat4 = new Cat("Murka", "black-white", 6);
        Cat cat5 = new Cat("Turbo", "orange", 4);
        Dog dog = new Dog("Volvo", "black", 3);
        Dog dog1 = new Dog("Pluto", "brown", 7);
        Animal dog2 = new Dog("Vice", "white", 1);


        cat.run(150);
//        cat.run(-10);
//        cat.run(1000);


//        cat.swim(100);

        dog.run(50.0);
//        dog.run(750.0);
//        dog.run(-50.0);

        dog.swim(5.7);
//        dog.swim(10.1);
//        dog.swim(-10.1);

        cat.print();
        dog.print();
        animal.print();

    }
}
