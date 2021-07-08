package HWork_7;

public class Cat {
    private String name;
    private int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        System.out.println(name + " eat...");
        plate.decrease(this);
    }

    public boolean checkHungry(Plate plate) {
        if (plate.getFood() > appetite) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }


}
