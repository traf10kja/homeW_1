package HWork_6.animals;

public class Cat extends Animal {

    static int count = 0;

    public Cat(String name, String color, int age) {
        super(name, color, age);
        count++;
    }

    @Override
    public void print() {
        System.out.println("Котов создано: " + count);
    }

    @Override
    public void run(double runDistance) {
        if (runDistance < 0) {
            System.out.println("Коты задом наперёд не бегают!");
        } else if (runDistance > 0 && runDistance <= 200) {
            System.out.printf("%s пробежал %.2fм\n", name, runDistance);
        } else {
            System.out.printf("%s не может столько пробежать, ни какой кот не смог бы!\n", name);
        }
    }

    @Override
    public void swim(double swimDistance) {
        System.out.println("Коты не плавают!");
    }
}
