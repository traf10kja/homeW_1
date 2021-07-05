package HWork_6.animals;



public class Animal {
    String name;
    String color;
    int age;
    static int bigCount;


    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        bigCount++;
    }


    public void print() {
        System.out.println("Создано животных: " + bigCount);
    }

    public void run(double runDistance) {
        System.out.printf("%s пробежал %.2fм\n", name, runDistance);
    }

    public void swim(double swimDistance) {
        System.out.printf("%s проплыл %.2fм\n", name, swimDistance);
    }
}