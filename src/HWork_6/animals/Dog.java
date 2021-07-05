package HWork_6.animals;

public class Dog extends Animal {

    static int count1 = 0;


    public Dog(String name, String color, int age) {
        super(name, color, age);
        count1++;
    }

    @Override
    public void print() {
        System.out.println("Собак создано: " + count1);
    }

    @Override
    public void run(double runDistance) {
        if (runDistance < 0) {
            System.out.println("Собаки задом наперёд не бегают!");
        } else if (runDistance > 0 && runDistance <= 500) {
            System.out.printf("%s пробежал %.2fм\n", name, runDistance);
        } else {
            System.out.printf("%s не может столько пробежать, ни один пёс на свете не смог бы!\n", name);
        }
    }

    @Override
    public void swim(double swimDistance) {
        if (swimDistance < 0) {
            System.out.println("Собаки задом наперёд не плаваают!");
        } else if (swimDistance > 0 && swimDistance <= 10) {
            System.out.printf("%s проплыл %.2fм\n", name, swimDistance);
        } else {
            System.out.printf("%s не может столько проплыть!\n", name);
        }
    }
}
