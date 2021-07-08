package HWork_7;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(100);

//        cat.eat(plate);
//        cat2.eat(plate);

//        System.out.println(plate);

        Cat[] cats = {
                new Cat("Turbo", 12),
                new Cat("Mini", 9),
                new Cat("Speedy", 20),
                new Cat("Fatty", 44),
                new Cat("Murka", 17),
        };

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
        }
        System.out.println(plate);

    }
}
